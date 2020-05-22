public enum Fields {
    LAST_NAME("Last Name"), FIRST_NAME("First Name");

    private final String fieldDescription;

    private Fields(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }
}