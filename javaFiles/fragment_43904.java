public void run(String domain, int rps, int durationInSeconds, String host){
    StandardJMeterEngine jMeterEngine = new StandardJMeterEngine();

    //Setting JMeter Properties
    File properties = JmeterUtils.getPropertiesFile();
    File home = JmeterUtils.getHomePath();
    JMeterUtils.setJMeterHome(home.getPath());
    JMeterUtils.loadJMeterProperties(properties.getPath());
    JMeterUtils.initLocale();

    //Creating HashTreeTestPlan
    HashTree testPlanTree = new HashTree();

    //Creating HttpSampler
    HTTPSamplerProxy httpSamplerProxy = JmeterUtils.createHttpSamplerGet(domain);

    //Creating Header Manager
    HeaderManager headerManager = JmeterUtils.createHeaderManager(host);

    //Creating LoopController
    LoopController loopController = JmeterUtils.createLoopController(-1, true);

    //Creating the number of Threads (clients)
    ThreadGroup threadGroup = JmeterUtils.createThreadGroup(domain, rps, durationInSeconds, loopController);

    //Adding Request Manager To requests HashTree
    HashTree requestHashTree = new HashTree();
    requestHashTree.add(httpSamplerProxy, headerManager);

    //Creating Throughput Timer - Controls the RPS
    ConstantThroughputTimer timer = JmeterUtils.createTimer(rps);

    //Creating Test Plan
    TestPlan testPlan = JmeterUtils.createTestPlan(domain);

    // Construct Test Plan from previously initialized elements
    testPlanTree.add(testPlan);
    HashTree threadGroupHashTree = testPlanTree.add(testPlan, threadGroup);
    threadGroupHashTree.add(requestHashTree);
    threadGroupHashTree.add(timer);

    //Configuring the Engine & Running the Test
    jMeterEngine.configure(testPlanTree);
    jMeterEngine.runTest();