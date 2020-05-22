public class Program {

    private TestObject testObject = new TestObject();
    private TestObject spyTestObject;

    @BeforeMethod
    public void buildSpy() {
        spyTestObject = spy(testObject);
    }

    @Test
    public void test1() {
       spyTestObject.makeSth(); 
       verify(spyTestObject , only()).someMethodNeedToBeChecked(); 
    }

    @Test
    public void test2() {
        // Some different scenario
       spyTestObject.makeSth(); 
       verify(spyTestObject , only()).someMethodNeedToBeChecked(); 
        ...
    }
}