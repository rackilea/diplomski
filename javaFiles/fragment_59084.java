import javax.xml.bind.JAXBContext;
import javax.xml.namespace.QName;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import blog.jaxws.provider.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        QName serviceName = new QName("http://service.jaxws.blog/", "FindCustomerService");
        Service service = Service.create(serviceName);
        QName portQName = new QName("http://example.org", "SimplePort");
        service.addPort(portQName, SOAPBinding.SOAP11HTTP_BINDING, "http://localhost:8080/Provider/FindCustomerService?wsdl");

        JAXBContext jc = JAXBContext.newInstance(FindCustomerRequest.class, FindCustomerResponse.class);
        Dispatch<Object> sourceDispatch = service.createDispatch(portQName, jc, Service.Mode.PAYLOAD);
        FindCustomerRequest request = new FindCustomerRequest();
        FindCustomerResponse response = (FindCustomerResponse) sourceDispatch.invoke(request);
        System.out.println(response.getValue().getFirstName());
    }

}