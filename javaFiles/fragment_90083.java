public enum Styles {

    TABLE_STYLE("TableGrid"),
    FONT_FAMILY("Calibri"),
    HEADER_STYLE("Heading2"),
    FOOTER_STYLE("Heading3"),
    TABLE_HEADER_STYLE("Heading1"),
    TABLE_DATA_FONT_FAMILY("Cambria"),
    TABLE_HEADER_FONT_SIZE("16"),
    TABLE_DATA_FONT_SIZE("12");

    private String value;

    private Styles(String value) {
        this.value = value;
    }

    public String getStringValue() {
        return value;
    }

    public int getIntValue() {
        return Integer.valueOf(value);
    }

}