public class MyTest {
    @Test
    public void throwsExceptionWithSpecificTypeAndMessage() {
        try { // !
            // do something ...
            // after that, fail the test:
            org.junit.Assert.fail("expected exception!");
        } catch (Exception exc) { // ! here i would recommend "the highest possible Exception" (in inheritance hierarchy) ...even better <code>Throwable</code>.
           // this code can be moved to a (static) util method:
           if (exc instanceof MyCustomException) {
               // make assertions on ((MyCustomException) exc).getMessage();
           } else {
               org.junit.Assert.fail("UNexpected exception!");
               // or rethrow:
               // throw exc;
           }
        }          
    }
}