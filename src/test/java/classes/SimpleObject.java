package classes;

public class SimpleObject {

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
}
