import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType (name = "Person", propOrder = {"name","surname", "age"})
public class Person {
    @XmlElement(name="name",required = true)
    private String name;

    @XmlElement(name="surname",required = true)
    private String surname;

    @XmlElement(name="age",required = true)
    private int age;

//GETTER & SETTER
}