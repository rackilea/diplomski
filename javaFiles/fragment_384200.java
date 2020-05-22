@XmlElements({ 
    @XmlElement(type=Man.class),
    @XmlElement(type=Female.class),
    @XmlElement(type=Child.class)
})
private List<? extends User> parents;