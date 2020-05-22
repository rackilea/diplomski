try {
    responseCode = customReportConnection.getResponseCode();
    return httpResponseBodyExtractor.extractResponseBodyFrom(customReportConnection);
} catch (IOException e) {
    translateIntoRelevantException(responseCode, e);
    throw new RuntimeException("should never come here");
}