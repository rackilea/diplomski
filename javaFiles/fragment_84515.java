public class MyHandlerResolver implements HandlerResolver
{
  @Override
  public List<Handler> getHandlerChain(PortInfo portInfo)
  {
    List<Handler> handlerChain = Lists.newArrayList();
    Handler soapHandler = new MySoapHandler();
    String bindingID = portInfo.getBindingID();

    if (bindingID.equals("http://schemas.xmlsoap.org/wsdl/soap/http"))
    {
      handlerChain.add(soapHandler);
    }
    else if (bindingID.equals("http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/"))
    {
      handlerChain.add(soapHandler);
    }

    return handlerChain;
  }
}