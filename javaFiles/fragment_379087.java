public class AuthenticationInterceptor extends
        AbstractPhaseInterceptor<SoapMessage> {

    public AuthenticationInterceptor(){
        super(Phase.PRE_INVOKE);
    }

    @Override
    public void handleFault(SoapMessage message) {
        super.handleFault(message);
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        Set _set = message.getContentFormats();
        Iterator classIterator = _set.iterator();
        while (classIterator.hasNext()) {
            Class _class = (Class) classIterator.next();
            Object _obj = message.getContent(_class);
        }    
    }

}