import javax.xml.transform.Source;
import javax.xml.ws.Provider;
import javax.xml.ws.Service;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceProvider;

@WebServiceProvider(serviceName="EchoService", portName="EchoPort")
@ServiceMode(value=Service.Mode.PAYLOAD)
public class EchoPayloadProvider implements Provider<Source> {
    public Source invoke(Source request) throws WebServiceException {
        // just echo back
        return request;
    }
}