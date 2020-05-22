@XmlRootElement(name="TAG", namespace = "xxxxxxxx/tag")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tag {

    @XmlElement(name = "home", namespace = "xxxxxxxx/tag")
    private Home home;
    @XmlElement(name = "help", namespace = "xxxxxxxx/tag")
    private Help help;

}