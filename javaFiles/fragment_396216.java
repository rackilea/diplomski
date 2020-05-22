@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlElements({
        @XmlElement(name="response1", type=Response.class),
        @XmlElement(name="response2", type=Response.class),
        @XmlElement(name="response3", type=Response.class)
    })
    private Response response;

}