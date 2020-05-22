final LauncherDiscoveryRequest request = 
    LauncherDiscoveryRequestBuilder.request()
                                   .selectors(selectClass(TestClass.class))
                                   .build();

final Launcher launcher = LauncherFactory.create();
final SummaryGeneratingListener listener = new SummaryGeneratingListener();

launcher.registerTestExecutionListeners(listener);
launcher.execute(request);

TestExecutionSummary summary = listener.getSummary();
long testFoundCount = summary.getTestsFoundCount();
List<Failure> failures = summary.getFailures();
...