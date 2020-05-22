@XmlRootElement(name = "nodeMap")
@XmlAccessorType(XmlAccessType.FIELD)
public class NodeMapDTO {
    @XmlElementWrapper(name = "ipAddresses")
    @XmlElement(name = "ipAddress")
    private List<IPAddressDTO> ipAddresses;

    NodeMapDTO() {
    }
    NodeMapDTO(IPAddressDTO... ipAddresses) {
        this.ipAddresses = Arrays.asList(ipAddresses);
    }
}