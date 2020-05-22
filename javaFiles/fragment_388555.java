public class SendManager {

    private static final String SEND_METHOD_NAME = "send";

    /* DAO for the CLASS_NAMES tables */
    private ClassNameDAO classNameDao;

    /**
     * Gets the row corresponding to methodId, for example
     * (1, "com.foo.SmsController", "com.foo.Manager") then using reflection
     * instantiates an instance of SmsController and invokes its send method
     * with <code>param</code> passed to it.
     */
    public void send(int methodId, Object param) throws Exception {
        ClassNameRow classNameRow = classNameDao.findByMethodId(methodId);

        String senderParameterClassName = className.senderParameterClassName();
        Class paramClass = Class.forName(senderParameterClassName);

        if (!paramClass.isInstance(param)) {
            throw new IllegalArgumentException("methodId and param are not compatible");
        }

        String senderClassName = classNameRow.getSenderClassName();
        Class senderClass = Class.forName(senderClassName);     

        /* Your sender classes must be JavaBeans and have no-arg constructors */
        Object sender = senderClass.newInstance();

        Class paramClass = Class.forName(senderParameterClassName);

        Method send = senderClass.getMethod(SEND_METHOD_NAME, paramClass);

        send.invoke(sender, param);
    }

}