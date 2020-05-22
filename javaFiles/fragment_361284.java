@XmlElements(value = {
        @XmlElement(name="address",
                    type=Address.class),
        @XmlElement(name="phone-number",
                    type=PhoneNumber.class),
        @XmlElement(name="note",
                    type=String.class)
})
private List<Object> contactInfo;