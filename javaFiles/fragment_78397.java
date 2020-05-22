@XmlAccessorType(XmlAccessType.FIELD)
public class ProfileSet {

    @XmlElement(name = "name")
    private String name;

    // template to store different profile objects    
    @XmlElements({
        @XmlElement(name = "organization-information-profile", type = OrganizationInfomationProfile.class),
        @XmlElement(name = "connection-profile", type = ConnectionProfile.class),
        @XmlElement(name = "user-information-profile", type = UserInformationProfile.class)
    })
    private Profile profile;

    // default constructor used by JAXB unmarshaller
    public ProfileSet() {
    }

    public ProfileSet(String name, Profile profile) {
        this.name = name;
        this.profile = profile;
    }
 }