public static enum API_ENDPOINT{
    MISSION("mission"), FEATURED_MEDIA("featured_media");
    private final String value;
    API_ENDPOINT(String value) { this.value = value; }
    public String value() { return value; }
}