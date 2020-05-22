public enum FooEnum implements WithText {
    AWESOME("awesome-rad"),
    NARLY("totally-narly");

    private final String text;

    FooEnum(String text) {
        this.text = text;
    }

    @Override
    @JsonValue
    public String getText() {
        return text;
    }

}