public class MySoapHandler implements SOAPHandler<SOAPMessageContext>
{

  @Override
  public boolean handleMessage(SOAPMessageContext soapMessageContext)
  {
    try
    {
      SOAPMessage message = soapMessageContext.getMessage();
      // I haven't tested this
      message.getSOAPHeader().setPrefix("soapenv");
      soapMessageContext.setMessage(message);
    }
    catch (SOAPException e)
    {
      // Handle exception
    }

    return true;
  }

  ...
}