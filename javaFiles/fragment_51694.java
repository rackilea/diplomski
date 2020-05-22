public static void addResultForTestCase(String testRunId, String testCaseId, int status,String error) throws IOException, APIException {
    String testRunId = TEST_RUN_ID;

    APIClient client = new APIClient(RAILS_ENGINE_URL);
    client.setUser(TESTRAIL_USERNAME);
    client.setPassword(TESTRAIL_PASSWORD);
    Map data = new HashMap();
    data.put("status_id", status);
    data.put("comment", "Test Executed - Status updated automatically from Selenium test automation.");
    client.sendPost("add_result_for_case/"+testRunId+"/"+testCaseId+"",data );
}