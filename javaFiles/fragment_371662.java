import java.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement
class A {
    @XmlElement
    String propertyOfA;

    @XmlPath(".")
    B b;
}