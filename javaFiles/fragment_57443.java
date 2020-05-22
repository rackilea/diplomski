@Embeddable
@XmlRootElement(name = "phone")
public static class Phone {

    @XmlElement(name = "area")
    @Column(name = "phone-area")
    private Integer area;

    @XmlElement(name = "number")
    @Column(name = "phone-number")
    private Integer number;

    // getter, setters
}