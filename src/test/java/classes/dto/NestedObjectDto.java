package classes.dto;

public class NestedObjectDto {
    private String testName;
    private int testAge;
    private SimpleNameDto simpleName;
    private SimpleAgeDto simpleAge;

    public NestedObjectDto() {}

    public NestedObjectDto(
        String testName, int testAge, SimpleNameDto simpleName, SimpleAgeDto simpleAge
    ) {
        this.testName = testName;
        this.testAge = testAge;
        this.simpleName = simpleName;
        this.simpleAge = simpleAge;
    }
}
