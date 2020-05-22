public class SecurityHandler implements SOAPHandler<SOAPMessageContext>
{
    @Override
    public boolean handleMessage(SOAPMessageContext context)
    {
        boolean outbound = (Boolean)context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if(outbound) {
            //logic to handle a response
        }

        if (!outbound) {
            //logic to handle a request
        }

        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {}

    @Override
    public Set<QName> getHeaders() {
        return Collections.emptySet();
    }

}