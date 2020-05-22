package forum7652387;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    @XmlElement(name="homeAddress_street")
    String street;

    @XmlElement(name="homeAddress_zip")
    String zip;
}