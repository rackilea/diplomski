QueryRequest testCaseRequest = new QueryRequest("testcase");
testCaseRequest.setQueryFilter(new QueryFilter("FormattedID", "=", "TC1"));
testCaseRequest.setFetch(new Fetch("FormattedID", "Name", "Steps"));

QueryResponse testCaseResponse = restApi.query(testCaseRequest);
JsonObject testCase = testCaseResponse.getResults().get(0).getAsJsonObject();
System.out.println(String.format("Found: %s - %s", testCase.get("FormattedID").getAsString(), testCase.get("Name").getAsString()));

//Inspect the steps collection
JsonObject steps = testCase.getAsJsonObject("Steps");
int stepCount = steps.get("Count").getAsInt();
System.out.println(String.format("\nTotal steps: %d", stepCount));

//Query the steps collection
QueryRequest stepRequest = new QueryRequest(steps);
stepRequest.setFetch(new Fetch("StepIndex","ExpectedResult","Input"));
QueryResponse queryResponse = restApi.query(stepRequest);
if (queryResponse.wasSuccessful()) {
    for (JsonElement result : queryResponse.getResults()) {
        JsonObject step = result.getAsJsonObject();
        System.out.println(String.format("\t%d: Input=%s, ExpectedResult=%s",
                step.get("StepIndex").getAsInt(),
                step.get("Input").getAsString(),
                step.get("ExpectedResult").getAsString()));
    }
}