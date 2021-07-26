package classes;

public class TwiceNestedObject {

    private InnerClass1 innerClass1;

    public TwiceNestedObject() {
    }

    public TwiceNestedObject(InnerClass1 innerClass1) {
        this.innerClass1 = innerClass1;
    }

    public static class InnerClass1 {
        private InnerClass2 innerClass2;

        public InnerClass1() {
        }

        public InnerClass1(InnerClass2 innerClass2) {
            this.innerClass2 = innerClass2;
        }
    }

    public static class InnerClass2 {
        String name;

        public InnerClass2() {
        }

        public InnerClass2(String name) {
            this.name = name;
        }
    }

    public static class TwiceNestedObjectDto {
        private InnerClass1Dto innerClass1;

        public TwiceNestedObjectDto() {
        }

        public TwiceNestedObjectDto(InnerClass1Dto innerClass1Dto) {
            this.innerClass1 = innerClass1Dto;
        }
    }

    public static class InnerClass1Dto {
        private InnerClass2Dto innerClass2;

        public InnerClass1Dto() {
        }

        public InnerClass1Dto(InnerClass2Dto innerClass2Dto) {
            this.innerClass2 = innerClass2Dto;
        }
    }

    public static class InnerClass2Dto {
        private String name;

        public InnerClass2Dto() {
        }

        public InnerClass2Dto(String name) {
            this.name = name;
        }
    }
}
