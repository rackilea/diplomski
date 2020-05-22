public class GetTestFolder {

    public static void main(String[] args) throws Exception {

        String host = "https://rally1.rallydev.com";
        String applicationName = "Example: get Folder of TestCase";
        String projectRef = "/project/12352608219";
        String apiKey = "_abc123";
        RallyRestApi restApi = null;
        try {
            restApi = new RallyRestApi(new URI(host),apiKey);
            restApi.setApplicationName(applicationName);
            QueryRequest testCaseRequest = new QueryRequest("TestCase");
            testCaseRequest.setProject(projectRef);

            testCaseRequest.setFetch(new Fetch(new String[] {"FormattedID","Name","TestFolder"}));
            testCaseRequest.setQueryFilter(new QueryFilter("FormattedID", "=", "TC47"));
            testCaseRequest.setScopedDown(false);
            testCaseRequest.setScopedUp(false);

            QueryResponse testCaseResponse = restApi.query(testCaseRequest);
            System.out.println("Successful: " + testCaseResponse.wasSuccessful());
            for (int i=0; i<testCaseResponse.getResults().size();i++){
                JsonObject testCaseJsonObject = testCaseResponse.getResults().get(i).getAsJsonObject();
                System.out.println("Name: " + testCaseJsonObject.get("Name") + " FormattedID: " + testCaseJsonObject.get("FormattedID") + " TestFolder: " + testCaseJsonObject.get("TestFolder").getAsJsonObject().get("Name"));

            }
        } finally {
            if (restApi != null) {
                restApi.close();
            }
        }
    }
}