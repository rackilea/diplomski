package test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Detail")
@XmlType(propOrder = { "firstname", "lastname"})
public class Detail {

    @XmlElement(name="firstname")
    private String firstname;

    @XmlElement(name="lastname")
    private String lastname;

    private String elementA = "default elementA";

    private String elementB = "default elementB";

    private String elementC = "default elementC";

    public Detail(){}

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getElementA() {
        return elementA;
    }

    public void setElementA(String elementA) {
        this.elementA = elementA;
    }

    public String getElementB() {
        return elementB;
    }

    public void setElementB(String elementB) {
        this.elementB = elementB;
    }

    public String getElementC() {
        return elementC;
    }

    public void setElementC(String elementC) {
        this.elementC = elementC;
    }
}