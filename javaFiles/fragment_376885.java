import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("response")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"response"})
public class ClientGenericResponse {

    String response;

    @XStreamAlias("type")
    String status;

    ClientID client_id;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ClientID getClient_id() {
        return client_id;
    }

    public void setClient_id(ClientID clientId) {
        client_id = clientId;
    }

    public static void main(String[] args) {

        XStream xstream = new XStream(); 
        xstream.processAnnotations(ClientGenericResponse.class);

        // Send request (this retrieves the xml above) 
        String xmlResponse = Utility.sendRequest(xml, true);

        ClientGenericResponse response = (ClientGenericResponse)xstream.fromXML(xmlResponse);
    }
}