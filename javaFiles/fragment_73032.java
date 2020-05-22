public class MyTest {
    @Rule 
    ExpectedException expExc = ExpectedException.none();

    @Test
    public void throwsNothing() {
        // "normal tests" not affected.
    }

    @Test
    public void throwsExceptionWithSpecificTypeAndMessage() {
       expExc.expect(MyCustomException.class);
       expExc.expectMessage("substring, that passes test");// other matchers possible
       // do something that (is expected to) raise(s) 
       // MyCustomException("substring, that passes test").
    }
}