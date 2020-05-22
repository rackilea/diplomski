import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Stereotype1 extends AbstractStereotype {
    public String getPath() {
        return "Path1";
    }
}