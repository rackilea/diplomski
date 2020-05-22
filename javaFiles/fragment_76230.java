@XmlRootElement(name = "Personel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Personel{

    @XmlPath("name/@value")
    String name;

    @XmlPath("surname/@value")
    String surname;
}