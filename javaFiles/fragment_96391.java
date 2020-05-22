package forum11001458;

import javax.xml.bind.annotation.XmlElement;

public class User {

    @XmlElement(name="Name")
    private String name;

    @XmlElement(name="Email")
    private String email;

}