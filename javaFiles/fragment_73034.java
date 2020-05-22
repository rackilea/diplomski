public class MyTest {
    @Rule 
    CustomExpectedException expExc = new CustomExpectedException();
    ...
    @Test
    public void throwsExceptionWithSpecificTypeAndMessage() {
       expExc.myExpect("substring, that passes test");
      // do something...
    }
}