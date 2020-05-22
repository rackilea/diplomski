@XmlType(name = "Component")
@XmlEnum
public enum Component {

    @XmlEnumValue("Common")
    common("Common");
    private final String value;

    Component(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Component fromValue(String v) {
        for (Component c: Component.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}