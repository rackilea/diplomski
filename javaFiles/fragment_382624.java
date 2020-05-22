@XmlRootElement(name = "request")
public class EccpRequestWrapper {
    @XmlAttribute
    private Long id;

    @XmlAnyElement
    private IEccpRequest request;
}