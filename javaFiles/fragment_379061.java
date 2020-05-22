// Handles at least the two methods shown.
public String findLogNumber(POITextExtractor we) {
    int logIndex;
    int logIndexEnd;
    String logNumber = "";
    if (we.getText().contains("Log ")) {
        logIndex = we.getText().indexOf("Log ") + 4;
        logIndexEnd = logIndex + 5;
        logNumber = we.getText().substring(logIndex, logIndexEnd);
    }
    return logNumber;
}