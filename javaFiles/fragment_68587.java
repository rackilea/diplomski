public class TestModel extends AbstractModel{

    @FieldRawValue("test2")
    private String test;

    public String getTest2() {
        return test;
    }

    public void setTest2(String test) {
        this.test = test;
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TestModel testModel = new TestModel();

        Object tst = testModel.get("test"); //== null
        testModel.set("test", "newVal"); //sets new value
        testModel.get("test"); //== "newVal
    }

}