public class Interceptor extends AbstractPhaseInterceptor<Message> {
    private ObjectFactory objectFactory = new ObjectFactory();

    public Interceptor() {
        super(Phase.PRE_LOGICAL);
        addBefore(HolderOutInterceptor.class.getName());
    }

    @Override
    public void handleMessage(Message message) {
        MessageContentsList outObjects = MessageContentsList.getContentsList(message);
        Assert.isTrue(outObjects.size() == 1);
        Object outObject = outObjects.get(0);
        // object is our soap response
    }
}