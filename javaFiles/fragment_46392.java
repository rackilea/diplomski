import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Config {

    private List<Property> logProperties = new ArrayList<Property>();
    private List<Property> envProperties = new ArrayList<Property>();

    @XmlElementWrapper(name="log")
    @XmlElement(name="property")
    public List<Property> getLogProperties() {
        return logProperties;
    }

    @XmlElementWrapper(name="env")
    @XmlElement(name="property")
    public List<Property> getEnvProperties() {
        return envProperties;
    }

}