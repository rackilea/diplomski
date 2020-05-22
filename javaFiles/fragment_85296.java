int numberOfTestCases = testSetJsonObject.get("TestCases").getAsJsonArray().size();
if(numberOfTestCases>0) {
    for (int j=0;j<numberOfTestCases;j++) {
       System.out.println(testSetJsonObject.get("TestCases").getAsJsonArray().get(j).getAsJsonObject().get("FormattedID"));
    }
}