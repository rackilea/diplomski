// Create and configure a new instance of RallyRestApi
    RallyRestApi restApi = new RallyRestApi(new URI("https://rally1.rallydev.com"), 
            "user@company.com", "password");
    restApi.setWsapiVersion("1.34");
    restApi.setApplicationName("RestExample_AddTagsToTestCase");        

    //Query User
    QueryRequest userRequest = new QueryRequest("User");
    userRequest.setFetch(new Fetch("UserName", "Subscription", "DisplayName"));
    userRequest.setQueryFilter(new QueryFilter("UserName", "=", "user@company.com"));
    QueryResponse userQueryResponse = restApi.query(userRequest);
    JsonArray userQueryResults = userQueryResponse.getResults();
    JsonElement userQueryElement = userQueryResults.get(0);
    JsonObject userQueryObject = userQueryElement.getAsJsonObject();
    String userRef = userQueryObject.get("_ref").toString();

    // Query for Test Case to which we want to add results
    QueryRequest testCaseRequest = new QueryRequest("TestCase");
    testCaseRequest.setFetch(new Fetch("FormattedID","Name"));
    testCaseRequest.setQueryFilter(new QueryFilter("FormattedID", "=", "TC4"));
    QueryResponse testCaseQueryResponse = restApi.query(testCaseRequest);
    JsonObject testCaseJsonObject = testCaseQueryResponse.getResults().get(0).getAsJsonObject();
    String testCaseRef = testCaseQueryResponse.getResults().get(0).getAsJsonObject().get("_ref").toString();

    try {

        //Add a Test Case Result                
        System.out.println("Creating Test Case Result...");
        JsonObject newTestCaseResult = new JsonObject();
        newTestCaseResult.addProperty("Verdict", "Pass");
        newTestCaseResult.addProperty("Date", "2012-06-12T18:00:00.000Z");
        newTestCaseResult.addProperty("Notes", "Automated Selenium Test Runs");
        newTestCaseResult.addProperty("Build", "2012.05.31.0020101");
        newTestCaseResult.addProperty("Tester", userRef);
        newTestCaseResult.addProperty("TestCase", testCaseRef);

        CreateRequest createRequest = new CreateRequest("testcaseresult", newTestCaseResult);
        CreateResponse createResponse = restApi.create(createRequest);            

        if (createResponse.wasSuccessful()) {

            System.out.println(String.format("Created %s", createResponse.getObject().get("_ref").getAsString()));          

            //Read Test Case
            String ref = Ref.getRelativeRef(createResponse.getObject().get("_ref").getAsString());
            System.out.println(String.format("\nReading Test Case Result %s...", ref));
            GetRequest getRequest = new GetRequest(ref);
            getRequest.setFetch(new Fetch("Date", "Verdict"));
            GetResponse getResponse = restApi.get(getRequest);
            JsonObject obj = getResponse.getObject();
            System.out.println(String.format("Read Test Case Result. Date = %s, Verdict = %s",
                    obj.get("Date").getAsString(), obj.get("Verdict").getAsString()));                 
        } else {
            String[] createErrors;
            createErrors = createResponse.getErrors();
            System.out.println("Error occurred creating Test Case: ");
            for (int i=0; i<createErrors.length;i++) {
                System.out.println(createErrors[i]);
            }
        }

    } finally {
        //Release all resources
        restApi.close();
    }