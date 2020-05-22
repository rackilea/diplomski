public class exampleClass AbstractHandler implements org.apache.axis2.modules.Module {

public InvocationResponse invoke(MessageContext ctx) throws AxisFault {

SOAPEnvelope env = ctx.getEnvelope();
SOAPHeader hdr = env.getHeader();

SOAPFactory factory = (SOAPFactory) env.getOMFactory();

OMNamespace ns = factory.createOMNamespace("http://google.com", "cor");

//SOAPHeader head = factory.createSOAPHeader(env);

hdr.addHeaderBlock("india", ns).setText("value here");

return InvocationResponse.CONTINUE;
}


public void applyPolicy(Policy arg0, AxisDescription arg1) throws AxisFault {
    // TODO Auto-generated method stub

}

public boolean canSupportAssertion(Assertion arg0) {
    // TODO Auto-generated method stub
    return false;
}

public void engageNotify(AxisDescription arg0) throws AxisFault {
    // TODO Auto-generated method stub

}

public void init(ConfigurationContext arg0, AxisModule arg1) throws AxisFault {
    // TODO Auto-generated method stub

}

public void shutdown(ConfigurationContext arg0) throws AxisFault {
    // TODO Auto-generated method stub

} }