import java.util.*;
import javax.xml.bind.annotation.XmlElement;

public class Visitor {

    private List<String> attributes = new ArrayList<String>();

    @XmlElement(name="AttributeName")
    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

}