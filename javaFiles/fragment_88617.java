public static void main(final String[] args) {
    final String json = "{\"testSuiteInfo\":{\"description\":\"parse\"}," +
            "\"listOfTestCases\":{" +
            "\"testCaseData\":[" +
            "{\"sequence\":\"sequential\",\"testNumber\":\"2\",\"testCaseFile\":\"testcase\\\\Web\\\\Ab.xml\"}," +
            "{\"sequence\":\"sequential\",\"testNumber\":\"3\",\"testCaseFile\":\"testcase\\\\Web\\\\BC.xml\"}" +
            "]" +
            "}" +
            "}";

    final ObjectMapper mapper = new ObjectMapper();

    try {
        final TestSuite readValue = mapper.readValue(json, TestSuite.class);
        System.out.println(readValue.getListOfTestCases()); //just a test to see if the object is built
    }
    catch (final Exception e) {
        e.printStackTrace();
    }
}