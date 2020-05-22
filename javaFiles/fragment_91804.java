public class MyFactory {
    @Factory
    public Object[] dp() {
        Object[] data = new Object[] {
            new MyTest("1", "TestCase1", "Sample test 1"), new Mytest("1", "TestCase1", "Sample test 1"), new MyTest("1", "TestCase1", "Sample test 1")
        };
        return data;
    }
}