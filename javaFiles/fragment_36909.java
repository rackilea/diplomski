private boolean analyzeLinesCoveredByTests(String sessionId,
                      ExecutionDataStore executionDataStore) {

    int i = sessionId.indexOf(' ');
    if (i < 0) {
      return false;
    }
    String testClassName = sessionId.substring(0, i);
    String testName = sessionId.substring(i + 1);
    InputFile testResource = javaResourceLocator
                                .findResourceByClassName(testClassName);
    ...