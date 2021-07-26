package dtobinder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DtoBinder {

    private final Object sourceObject;
    private final Map<String, Class<?>> dtoField;

    public DtoBinder(Object sourceObject) {
        this.sourceObject = sourceObject;
        this.dtoField = new HashMap<>();
    }

    public DtoBinder toDto(String fieldName, Class<?> dtoType) {
        dtoField.put(fieldName, dtoType);
        return this;
    }

    public <T> T bindAs(Class<T> targetDto) {
        return bind(sourceObject, targetDto, "");
    }

    private <T> T bind(Object o, Class<T> targetDto, String prefix) {
        try {
            Map<String, Pair> source = parseParams(o, prefix);
            Constructor<T> constructor = targetDto.getConstructor();
            T t = constructor.newInstance();

            Field[] fields = targetDto.getDeclaredFields();

            for (Field field : fields) {
                field.trySetAccessible();

                String name = field.getName();
                Pair pair = source.get(name);
                if (pair != null && (field.getType().equals(pair.typeToken))) {
                    field.set(t, pair.o);
                }
            }

            return targetDto.cast(t);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    private Map<String, Pair> parseParams(Object o, String prefix) throws IllegalAccessException {
        Map<String, Pair> parsedParams = new HashMap<>();

        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.trySetAccessible();
            Class<?> fieldType = field.getType();
            String fieldName = field.getName();
            String nestedFieldName = prefix.isBlank() ? fieldName : String.format("%s.%s", prefix, fieldName);

            if (fieldType.isPrimitive() || fieldType.getCanonicalName().startsWith("java.lang")) {
                //기본 타입
                parsedParams.put(fieldName, new Pair(field.get(o), fieldType));
            } else if (dtoField.containsKey(nestedFieldName)) {
                //dto로 취급 되어야 함
                Class<?> dtoType = dtoField.get(nestedFieldName);

                parsedParams.put(fieldName, new Pair(bind(field.get(o), dtoType, nestedFieldName), dtoType));
            } else {
                // embedded로 취급
                parsedParams.putAll(parseParams(field.get(o), o.getClass().getName()));
            }
        }

        return parsedParams;
    }

    private static class Pair {

        Object o;
        Class<?> typeToken;

        public Pair(Object o, Class<?> typeToken) {
            this.o = o;
            this.typeToken = typeToken;
        }
    }
}
