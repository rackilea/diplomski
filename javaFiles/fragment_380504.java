if (offset > 0) {
    String startFrom = "bytes= " + offset + "-";
    if (expected >= 0) {
        startFrom += expected;
    }
    mHttpGet.addHeader("Range", startFrom);
    expectedStatusCode = HttpStatus.SC_PARTIAL_CONTENT;
}