@XmlAccessorType(XmlAccessType.FIELD)
public class OrganizationInfomationProfile extends Profile {

    @XmlElement(name = "qualified-name")
    private String qualifiedName;

    @XmlElement(name = "last-name")
    private String lastName;

    @XmlElement(name = "address")
    private String address;

    // ... other properties

}