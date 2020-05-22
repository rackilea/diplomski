public class ApplicationListener implements ApplicationEventListener {

    @Inject
    private ServiceLocator locator;

    @Override
    public void onEvent(ApplicationEvent ae) {
        switch (ae.getType()) {
            case DESTROY_FINISHED: {
                SampleProducer producer = locator.getService(SampleProducer.class);
                producer.destroy();
            }
        }
    }

    @Override
    public RequestEventListener onRequest(RequestEvent re) {
        return null;
    }   
}