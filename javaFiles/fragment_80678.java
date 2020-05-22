public class MyTest {
    @Test
    public void testMethod() {
        ClassThatIsUsingTheConfig var = new ClassThatIsUsingTheConfig(TEST_ENDPOINT);
        var.someMethod();
    }
}

public class MyProdClass {
    public void prodMethod() {
        ClassThatIsUsingTheConfig var = new ClassThatIsUsingTheConfig(PROD_ENDPOINT);
        var.someMethod();
    }
}