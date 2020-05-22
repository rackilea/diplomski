public class NodeSearchResult {
    private String xPath;
    private String value;

    public NodeSearchResult(String xPath, String value) {
        this.xPath = xPath;
        this.value = value;
    }
    // getters and setters
    @Override
    public String toString() {
        return String.format("%s = %s", getXPath(), getValue());
    }
}