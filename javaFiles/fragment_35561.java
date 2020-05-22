package examples.webservices.soap12;
...
import javax.jws.WebMethod;
import javax.jws.WebService;
import weblogic.jws.Binding;
@WebService(name="SOAP12PortType",
        serviceName="SOAP12Service",
        targetNamespace="http://example.org")
@Binding(Binding.Type.SOAP12)
public class SOAP12Impl {
  @WebMethod()
  public String sayHello(String message) {
  ...
 }
}