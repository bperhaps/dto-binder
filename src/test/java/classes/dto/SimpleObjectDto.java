package classes.dto;

public class SimpleObjectDto {

    private int number;
    private Integer ObjectNumber;
    private String string;
    private boolean primitiveBoolean;
    private Boolean ObjectBoolean;
    private Long ObjectLong;
    private long primitiveLong;

    public SimpleObjectDto() {
    }

    public SimpleObjectDto(
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
