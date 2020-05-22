import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="root")
public class TestBean {

    @XmlTransient
    private String name = null;

    @XmlElement(name="lastname")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}