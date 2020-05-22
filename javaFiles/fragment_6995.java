TestResult result = new TestResult();
ts.run(result);

for (Enumeration<TestFailure> failures = result.failures(); failures.hasMoreElements();) {
    TestFailure testFailure = failures.nextElement();
    System.out.println("Failure: " + testFailure.toString());      
}