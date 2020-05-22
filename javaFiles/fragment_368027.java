public interface APropertySetter {
    public void setProperty(String propertyValue);
}

public static class A {

    private String fieldName;
    private String detailFieldName;
    private String externalFieldName;
    private int formatLength;

    private Map<String, APropertySetter> propertySetter;
    /* additional private members */

    public A() {
        propertySetter = new HashMap<>();
        propertySetter.put(AField.FieldName.getName(), (APropertySetter) (String propertyValue) -> {
            fieldName = propertyValue;
        });
        propertySetter.put(AField.DetailFieldName.getName(), (APropertySetter) (String propertyValue) -> {
            detailFieldName = propertyValue;
        });
        propertySetter.put(AField.ExternalFieldName.getName(), (APropertySetter) (String propertyValue) -> {
            externalFieldName = propertyValue;
        });
        propertySetter.put(AField.FormatLength.getName(), (APropertySetter) (String propertyValue) -> {
            formatLength = Integer.parseInt(propertyValue);
        });
    }

    void setProperty(String aPropertyName, String aPropertyValue) {
        try {
            propertySetter.get(aPropertyName).setProperty(aPropertyValue);
        } catch (Exception e) {
            /* logging exceptions */
        }
    }
}