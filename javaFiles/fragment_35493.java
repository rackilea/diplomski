public interface TestInterface {
    Integer getField();     
}

public class TestClass implements TestInterface{

    @Attribute(required = true)
    private Integer field;

    public TestClass() {
    }

    public TestClass(Integer field) {
        this.field = field;
    }

    public Integer getField() {
        return field;
    }

    public void setField(Integer field) {
        this.field = field;
    }
}

public class NewTestClass implements TestInterface{

    @Attribute
    private Integer field;

    public NewTestClass() {
    }

    public NewTestClass(Integer field) {
        this.field = field;
    }

    public Integer getField() {
        return field;
    }

    public void setField(Integer field) {
        this.field = field;
    }
}