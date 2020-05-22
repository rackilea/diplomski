@XmlRootElement(name = "fighter")
@XmlAccessorType(XmlAccessType.FIELD)
public class Fighter{

    @XmlElement
    private int health;

    @XmlElement
    private int energy;

    @XmlElement
    private String name;

    @XmlElementWrapper(name = "abilitiesList")
    @XmlElement(name = "ability")
    private List<String> abilities;
}