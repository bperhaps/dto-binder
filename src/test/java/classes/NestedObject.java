package classes;

public class NestedObject {

    private String testName;
    private int testAge;
    private SimpleName simpleName;
    private SimpleAge simpleAge;

    public NestedObject() {
    }

    public NestedObject(
        String testName, int testAge, SimpleName simpleName, SimpleAge simpleAge
    ) {
        this.testName = testName;
        this.testAge = testAge;
        this.simpleName = simpleName;
        this.simpleAge = simpleAge;
    }
}
