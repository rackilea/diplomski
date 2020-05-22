package forum10548370;

import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name="message", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Message {

    @XmlPath("gtm:header/someid/text()")
    private String id;

    @XmlPath("gtm:header/sometext/text()")
    private String text;

    @XmlElement(namespace="http:// www.example.com/working/gtm")
    private String customer;

}