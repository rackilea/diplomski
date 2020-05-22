@XmlAccessorType(XmlAccessType.FIELD)
public class IPAddressDTO {
    @XmlValue
    private String ipAddress;

    IPAddressDTO() {
    }
    IPAddressDTO(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}