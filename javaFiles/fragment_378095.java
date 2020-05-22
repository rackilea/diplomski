private Map<String, Integer> testBeginOper(String environment, String case) {
    // do your actual tests using the given parameters "environment" and "case"
}

@Test
public void runTests() {
    List<Map<String, Integer>> results = new ArrayList<>();
    for(String environment : environments) {
        for(String case : cases) {
            results.add(testBeginOper(environment, case));
        }
    }
    // now compare your results
}