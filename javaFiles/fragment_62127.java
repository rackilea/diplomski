import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import de.dpag.postfinder.webservice.AutomatWS;
import de.dpag.postfinder.webservice.InputAddress;
import de.dpag.postfinder.webservice.WebServiceImpl;
import de.dpag.postfinder.webservice.WebServiceImplService;

public class DHLWebService {


    //wsdl path
private static final String RELATIVE_WSDL_PATH = "";

public static void main(String[] args) throws Exception {
    InputAddress request = new InputAddress();
    request.setCountryCode("DE");
    request.setCity("Bonn");
    request.setStreet("harles-de-Gaulle-Str");
    request.setStreetNo("20");
    request.setZip("53113");
    List<AutomatWS> packstationsByAddress = new ArrayList<>();
    try {
        URL wsdlLocalURL = DHLWebService.class.getResource(RELATIVE_WSDL_PATH);
      QName qName = new QName("http://postfinder.dpag.de/webservice", "WebServiceImplService");
      WebServiceImplService dhlClientService = new WebServiceImplService(wsdlLocalURL,qName);
      WebServiceImpl webServiceImplPort = dhlClientService.getWebServiceImplPort();
       Map<String, Object> req_ctx = ((BindingProvider) webServiceImplPort).getRequestContext();
       // replace it with your username and password
       req_ctx.put(BindingProvider.USERNAME_PROPERTY, "test");
       req_ctx.put(BindingProvider.PASSWORD_PROPERTY, "test");

      packstationsByAddress = webServiceImplPort.getPackstationsByAddress("", request);
    } catch (Exception e) {
      e.printStackTrace();
    }
    for (AutomatWS automatWS : packstationsByAddress) {
      System.out.println(automatWS.getAddress());
    }
  }

}