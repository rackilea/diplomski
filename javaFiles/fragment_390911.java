public class ThrowyWebAppContext extends WebAppContext {
    @Override
    protected void doStart() throws Exception {
        super.doStart();
        if (getUnavailableException() != null) {
            throw (Exception) getUnavailableException();
        }
    }
}