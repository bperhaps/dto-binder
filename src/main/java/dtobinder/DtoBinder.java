package dtobinder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class DtoBinder {

    private final Object sourceObject;

    public DtoBinder(Object sourceObject) {
        this.sourceObject = sourceObject;
    }

    public <T> T bindAs(Class<T> targetDto) {
        try {
            return bind(sourceObject, targetDto);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private <T> T bind(Object o, Class<T> targetDto)
        throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Map<String, Pair> source = parseParams(o);

        Constructor<T> constructor = targetDto.getConstructor();
        T t = constructor.newInstance();

        Field[] fields = targetDto.getDeclaredFields();

        for (Field field : fields) {
            field.trySetAccessible();

            String name = field.getName();
            Pair pair = source.get(name);
            if (pair.o != null && (field.getType().equals(pair.typeToken))) {
                field.set(t, pair.o);
            }
        }

        return targetDto.cast(t);
    }

    private Map<String, Pair> parseParams(Object o) throws IllegalAccessException {
        Map<String, Pair> parsedParams = new HashMap<>();

        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.trySetAccessible();

            Class<?> type = field.getType();
            if (type.isPrimitive() || type.getCanonicalName().startsWith("java.lang")) {
                parsedParams.put(field.getName(), new Pair(field.get(o), type));
            } else {
                parsedParams.putAll(parseParams(field.get(o)));
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
