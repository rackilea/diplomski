public enum MapType {
    ROADMAP("roadmap"), SATELLITE("satellite"), TERRAIN("terrain");
    private String text;

    private MapType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}