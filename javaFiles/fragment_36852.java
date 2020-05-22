@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public static class Customer {

    @XmlAttribute
    String id;

    @XmlElement
    NameAgeValue name;

    @XmlElement
    NameAgeValue age;

    public String getId() {
        return id;
    }

    public String getAge() {
        return (age == null) ? null : age.value;
    }

    public String getName() {
        return (name == null) ? null : name.value;
    }
}

@XmlType
public static class NameAgeValue {

    @XmlAttribute
    String value;
}