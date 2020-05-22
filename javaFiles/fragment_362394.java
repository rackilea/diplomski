@XmlRootElement(name = "ACCOUNT_CHANGES")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountChanges {

    @XmlElement(name = "TYPE")
    private Type type;

    @XmlElement(name = "RECORD")
    private Record record;

}