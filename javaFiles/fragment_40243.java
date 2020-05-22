@WebListener
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        // Do your job here on request begin.
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        // Do your job here on request end.
    }

}