for(TestCase testCase : allTestCaseList) {
    List<TestProperty> testCasePropertyList = testCase.getPropertyList();
       for (TestProperty testProperty : testCasePropertyList) {
            ((WsdlTestCase) testCase).removeProperty(testProperty.getName());
        }
}