import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TestWatcherExample {

    @Rule
    public MyTestWatcher myTestWatcher = new MyTestWatcher();

    @Test
    public void testName() throws Exception {
        System.out.println("hello");
        throw new Exception("ooops, something bad just happened");
    }

    public static class MyTestWatcher extends TestWatcher {

        @Override
        protected void failed(Throwable e, Description description) {
            super.failed(e, description);
            // Just doing my special stuff here
            System.out.println("test faild with this message " + e.getMessage());
        }

    }

}