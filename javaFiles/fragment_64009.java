public class Property {
    private final String name;
    private final String value;

    public Property(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static List<Property> toProperties(Object object, String... fieldNames)
        throws ReflectiveOperationException
    {
        ArrayList<Property> properties = new ArrayList<>();
        for( String fieldName : fieldNames ) {
            Field field = object.getClass().getDeclaredField(fieldName);
            properties.add(new Property(fieldName, field.get(object).toString()));
        }
        return properties;
    }

    public String toString() {
        return String.format("%s: \"%s\"", name, value);
    }
}