import static org.assertj.core.api.Assertions.assertThat;

import dtobinder.DtoBinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DtoBinderSimpleTest {

    @DisplayName("Bind simple dto and Object.")
    @Test
    void bind_bindSimpleDtoAndObject_returnBoundDto() {
        SimpleObject simpleObject = new SimpleObject(
            1, 2, "string", true, true, 3L, 4L
        );
        SimpleDto simpleDto = new DtoBinder(simpleObject).bindAs(SimpleDto.class);

        SimpleDto expected = new SimpleDto(
            simpleObject.getNumber(),
            simpleObject.getObjectNumber(),
            simpleObject.getString(),
            simpleObject.isPrimitiveBoolean(),
            simpleObject.getObjectBoolean(),
            simpleObject.getObjectLong(),
            simpleObject.getPrimitiveLong()
        );

        assertThat(simpleDto)
            .usingRecursiveComparison()
            .isEqualTo(expected);
    }

    public static class SimpleObject {

        private int number;
        private Integer ObjectNumber;
        private String string;
        private boolean primitiveBoolean;
        private Boolean ObjectBoolean;
        private Long ObjectLong;
        private long primitiveLong;

        public SimpleObject() {
        }

        public SimpleObject(
            int number, Integer objectNumber, String string, boolean primitiveBoolean,
            Boolean objectBoolean, Long objectLong, long primitiveLong
        ) {
            this.number = number;
            this.ObjectNumber = objectNumber;
            this.string = string;
            this.primitiveBoolean = primitiveBoolean;
            this.ObjectBoolean = objectBoolean;
            this.ObjectLong = objectLong;
            this.primitiveLong = primitiveLong;
        }

        public int getNumber() {
            return number;
        }

        public Integer getObjectNumber() {
            return ObjectNumber;
        }

        public String getString() {
            return string;
        }

        public boolean isPrimitiveBoolean() {
            return primitiveBoolean;
        }

        public Boolean getObjectBoolean() {
            return ObjectBoolean;
        }

        public Long getObjectLong() {
            return ObjectLong;
        }

        public long getPrimitiveLong() {
            return primitiveLong;
        }
    }

    public static class SimpleDto {

        private int number;
        private Integer ObjectNumber;
        private String string;
        private boolean primitiveBoolean;
        private Boolean ObjectBoolean;
        private Long ObjectLong;
        private long primitiveLong;

        public SimpleDto() {
        }

        public SimpleDto(
            int number, Integer objectNumber, String string, boolean primitiveBoolean,
            Boolean objectBoolean, Long objectLong, long primitiveLong
        ) {
            this.number = number;
            this.ObjectNumber = objectNumber;
            this.string = string;
            this.primitiveBoolean = primitiveBoolean;
            this.ObjectBoolean = objectBoolean;
            this.ObjectLong = objectLong;
            this.primitiveLong = primitiveLong;
        }
    }
}
