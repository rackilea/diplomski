@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "name", propOrder = { "username", "password" })
public static class newBean {
    @XmlElement(name = "username", required = true)
    protected String username;

    @XmlElement(name = "password", required = true)
    protected String password;
}