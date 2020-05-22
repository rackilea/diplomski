public class Person {
    public enum Sex {
        @XmlEnumValue("male")   MALE,
        @XmlEnumValue("female") FEMALE,
    }
    @XmlAttribute
    private Sex sex;
    @XmlAttribute
    private int age;
    @Value
    private String name;
}