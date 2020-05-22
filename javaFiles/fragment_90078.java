@XmlRootElement(name = "ip_addresses")
@XmlAccessorType(XmlAccessType.FIELD)
public class IPAddresses implements Serializable {
    private final static long serialVersionUID = 1L;

    @XmlElement(name = "ip_address")
    private List<IPAddress> ipAddresses;

    public List<IPAddress> getIpAddresses() {
        return ipAddresses;
    }
    public void setIpAddresses(List<IPAddress> ipAddresses) {
        this.ipAddresses = ipAddresses;
    }
}