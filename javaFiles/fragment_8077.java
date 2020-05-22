@XmlElements({
    @XmlElement(name="address", type=Address.class),
    @XmlElement(name="phoneNumber", type=PhoneNumber.class)
})
public List<ContactInfo> getContactInfo() {
    return contactInfo;
}