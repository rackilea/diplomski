import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name="response")
public class OurResponse {
    private String authCode;

    @XmlPath("subXml/authCode/text()")
    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

}