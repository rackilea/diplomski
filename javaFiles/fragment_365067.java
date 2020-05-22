package forum7652387;

import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    String name;

    @XmlPath(".")
    Address homeAddress;
}