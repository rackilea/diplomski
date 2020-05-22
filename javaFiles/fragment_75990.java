@XmlAccessorType(XmlAccessType.FIELD)
public class Call {

    @XmlAttribute
    private String name;
    private String repeat;
    private String delay;
    private String fields;
    @XmlElement(name="call")
    private List<Call> call;

}