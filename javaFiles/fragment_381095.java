import org.json.JSONObject;

def testStep = context.testCase.getTestStepByName("TestStep");

for (int i = 0; i < 10; i++) {
    final String json = testStep.getPropertyValue("Request");

    final JSONObject obj = new JSONObject(json);
    obj.put("Id", i);

    testStep.setPropertyValue("Request", obj.toString());
    testRunner.runTestStepByName(testStep.getName());
}