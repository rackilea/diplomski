import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({Stereotype1.class, Stereotype2.class})
public abstract class AbstractStereotype {

    @XmlAttribute
    public abstract String getPath();

}