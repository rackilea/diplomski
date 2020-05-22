public class Section {

    private String name;
    private List<Property> properties;
    // getters and setters

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        for (Property prop: properties) {
            sb.append("," + prop.getKey() + "=" + prop.getValue());
        }
        return sb.toString();
    }
}

public class Property {

    private String key;
    private String value;
    // getters and setters
}