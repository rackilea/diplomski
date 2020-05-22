@BeforeMethod
public void printData(Method method){
    System.out.println(method.getAnnotation(Test.class).testName());
    System.out.println(method.getAnnotation(Test.class).suiteName());
    System.out.println(method.getAnnotation(Test.class).description());
}

@Test(testName = "my test", suiteName = "my suite", description = "my description")
public void test(){
    // Test code
}