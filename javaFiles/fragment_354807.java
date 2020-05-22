@XmlRootElement(name="DeliveryDetails")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeliveryDetails {

    @XmlElement(name="Name")
    private String name;

    @XmlElement(name="Location")
    private String location;

    @XmlElement(name="Event")
    private List<Event> events;

}