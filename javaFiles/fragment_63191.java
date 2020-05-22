@XmlElementWrapper(name = "contacts")
@XmlElements({
    @XmlElement(name = "phone-number", type = Phone.class, required = true),
    @XmlElement(name = "home-address", type = Address.class, required = true)
})
private final List<ContactInfomation> contacts = new ArrayList<>();