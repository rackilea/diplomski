@XmlElementWrapper(name = "contacts")
@XmlElementRefs({
    @XmlElementRef(name = "phone", type = Phone.class, required = true),
    @XmlElementRef(name = "ADDRESS", type = Address.class, required = true)
})
private final List<ContactInfomation> contacts = new ArrayList<>();