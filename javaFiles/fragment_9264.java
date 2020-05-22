import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class MyWrapperClass {

    @XmlTransient
    public Existing existing;
    public Long myField;


    @XmlElement(name="id")
    public int getExisitingId() {
        return existing.id;
    }

    @XmlElement(name="fieldA")
    public String getExistingFieldA() {
        return existing.fieldA;
    }

}