public class LogData {

    private final String logMessage;
    private List<String> highlightedFragments = null;

    public LogData(String pLogMessage) {
        logMessage = pLogMessage;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public List<String> getHighlightedFragments() {
        if (highlightedFragments == null) {
            doHighlight();
        }
        return highlightedFragments;
    }

    private void doHighlight() {
        List<String> highlightedParts = Collections.emptyList(); // TODO lexer
        highlightedFragments = highlightedParts;
    }
}