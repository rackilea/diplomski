@RunWith(PowerMockRunner.class) // The runner of PowerMock
@PrepareForTest(MyOtherClass.class) // the class to prepare
public class MyClassTest {

    @Test
    public void test() throws Exception {
        // The mock of your static inner class to return
        MyClass.MyStaticClass mock = Mockito.mock(MyClass.MyStaticClass.class);
        // Mock the call of callSomeMethod()
        PowerMockito.doAnswer(
            new Answer<Void>() {
                @Override
                public Void answer(final InvocationOnMock invocation) throws Throwable {
                    // Do something here as new implementation of callSomeMethod
                    System.out.println("My new Answer");
                    return null;
                }
            }
        ).when(mock).callSomeMethod();
        // Return your mock in case we instantiate MyClass.MyStaticClass in 
        // the prepared class with any arguments  
        PowerMockito.whenNew(MyClass.MyStaticClass.class)
            .withArguments(Matchers.any(), Matchers.any(), Matchers.any())
            .thenReturn(mock);

        // The code that will call someMethod
        MyOtherClass mc = new MyOtherClass();
        mc.someMethod();
    }
}