@RunWith(PowerMockRunner.class)
    @PrepareForTest(ToBeTested .class)
    public class TestToBeTested{

    @before
    public void setup(){
      suppress(method(ToBeTested.class, "getResource"));
    }

    @Test
    public void testMethod(){
        doAnswer(new Answer<Void>() {
      @Override
      public MyResource answer(InvocationOnMock invocation) throws Throwable {
           return new MyResource();
      }
 }).when(ToBeTested.class, "getResource");
    }

       ToBeTested mock = mock(ToBeTested.class);
       mock.myMethod();
       //assert
    }