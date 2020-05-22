public class MyRequestContextListener
        extends RequestContextListener {

    @Override
    public void requestDestroyed( ServletRequestEvent requestEvent ) {

        super.requestDestroyed( requestEvent );
        applicationContext.getBean( SessionProvider.class ).cleanup();
    }
}