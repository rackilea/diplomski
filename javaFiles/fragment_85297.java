//TestCases is an object with a Count and a ref to load the collection
int numberOfTestCases = testSetJsonObject.getAsJsonObject("TestCases").get("Count").getAsInt();

if(numberOfTestCases > 0) {
    QueryRequest testCaseRequest = new QueryRequest(testSetJsonObject.getAsJsonObject("TestCases"));
    testCaseRequest.setFetch(new Fetch("FormattedID"));
    //load the collection
    JsonArray testCases = restApi.query(testCaseRequest).getResults();
    for (int j=0;j<numberOfTestCases;j++){
        System.out.println(testCases.get(j).getAsJsonObject().get("FormattedID").getAsString());
    }
}