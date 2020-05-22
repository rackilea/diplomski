final Duration TEST_DURATION = Duration.ofMinutes(15);

final Instant startTime = Instant.now();
final Instant finishTime = startTime.plus(TEST_DURATION);

final Tester tester = new GreedyTester(new AgentSystemModelTests());
tester.setRandom(new Random());
tester.buildGraph();
tester.addListener(new StopOnFailureListener());
tester.addListener("verbose");
tester.addCoverageMetric(new TransitionPairCoverage());
tester.addCoverageMetric(new StateCoverage());
tester.addCoverageMetric(new ActionCoverage());

// This is the magic predicate for the loop
while (Instant.now().isBefore(finishTime)) {
   tester.generate();
}
tester.printCoverage();