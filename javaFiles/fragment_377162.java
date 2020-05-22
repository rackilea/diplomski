import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="response")
public class OurResponse {
    private String authCode;

    @XmlJavaTypeAdapter(AuthCodeAdapter.class)
    @XmlElement(name="subXml")
    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

}