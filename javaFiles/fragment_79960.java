public enum IconImageTag {
    NONE("val1"),
    USD("val2"),
    EURO("val3");

    private final String value;

    private final Map<String, IconImageTag> valueMap = new HashMap<>();

    static {
        for (IconImageTag tag : values()) {
            valueMap.put(tag.value, tag);
        }
    }

    private IconImageTag(String value) {
        this.value = value;
    }

    public static IconImageTag fromValue(String value) {
        return valueMap.get(value);
    }
}