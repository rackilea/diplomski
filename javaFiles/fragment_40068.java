public class MyWatcher extends TestWatcher {
    @Override
    protected void failed(Throwable e, Description description) {
         callMyMethod();
    }
}