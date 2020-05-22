public TestSuite createTestSuite(TestSuite testSuite) {
    Set<TestCase> testCases = testSuite.getTestcases().stream()
        .map(this::getPersistedTestCase)
        .collect(Collectors.toSet());

    //set relationship to update the relationship table
    testSuite.setTestcases(testCases);
    testSuiteRepository.save(testSuite);
}

private TestCase getPersistedTestCase(TestCase testCase) {
    Optional<TestCase> persistedTestCase = testCaseRepository.findById(testCase.getId());
    if (persistedTestCase.isPresent()) {
        return persistedTestCase.get();
    }
    throw new IllegalArgumentException("Missing Test Case with id : " + testCase.getId());
}