public class JmeterUtils {

private static final File PROPERTIES_FILE = new File(System.getProperty("user.dir") + "/testdata/JMeter/bin/jmeter.properties");
private static final File HOME_PATH = new File(System.getProperty("user.dir") + "/testdata/JMeter");

static HeaderManager createHeaderManager(String host){
    HeaderManager headerManager = new HeaderManager();
    if(host != null){
        headerManager.add(new Header("Host",host));
    }
    headerManager.add(new Header("Connection", "Close"));
    headerManager.add(new Header("Cache-Control", "max-age=0"));
    headerManager.add(new Header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.5 (KHTML, like Gecko) Chrome/19.0.1084.52 Safari/536.5"));
    headerManager.setProperty(TestElement.TEST_CLASS, HeaderManager.class.getName());
    headerManager.setProperty(TestElement.GUI_CLASS, HeaderPanel.class.getName());
    headerManager.setEnabled(true);
    return headerManager;
}

static HTTPSamplerProxy createHttpSamplerGet(String domain){
    HTTPSamplerProxy sampler = new HTTPSamplerProxy();
    sampler.setMethod("GET");
    sampler.setDomain(domain);
    sampler.setUseKeepAlive(true);
    sampler.setFollowRedirects(true);
    sampler.setProperty(TestElement.TEST_CLASS, HTTPSamplerProxy.class.getName());
    sampler.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());
    sampler.setEnabled(true);
    return sampler;
}

static ThreadGroup createThreadGroup(String name, int numOfThreads, int durationInSeconds, LoopController loopController){
    ThreadGroup threadGroup = new ThreadGroup();
    threadGroup.setName(name);
    threadGroup.setNumThreads(numOfThreads);
    threadGroup.setScheduler(true);
    threadGroup.setRampUp(0);
    threadGroup.setDuration(durationInSeconds);
    threadGroup.setSamplerController(loopController);
    threadGroup.setProperty(TestElement.TEST_CLASS, ThreadGroup.class.getName());
    threadGroup.setProperty(TestElement.GUI_CLASS, ThreadGroupGui.class.getName());
    threadGroup.setEnabled(true);

    return threadGroup;
}

static LoopController createLoopController(int numOfLoops,boolean continueForever){
    LoopController loopController = new LoopController();
    if(continueForever){
        loopController.setLoops(-1);
    }
    else{
        loopController.setLoops(numOfLoops);
    }
    loopController.setFirst(true);
    loopController.setProperty(TestElement.TEST_CLASS, LoopController.class.getName());
    loopController.setProperty(TestElement.GUI_CLASS, LoopControlPanel.class.getName());
    loopController.initialize();
    loopController.setEnabled(true);

    return loopController;
}

static ConstantThroughputTimer createTimer(int rps){
    ConstantThroughputTimer timer = new ConstantThroughputTimer();
    long rpsCalc = rps * 60;
    timer.setProperty("throughput", rpsCalc);
    timer.setProperty("calcMode", 2);
    timer.setCalcMode(2);
    timer.setThroughput(rpsCalc);
    timer.setEnabled(true);
    timer.setProperty(TestElement.TEST_CLASS, ConstantThroughputTimer.class.getName());
    timer.setProperty(TestElement.GUI_CLASS, TestBeanGUI.class.getName());
    return timer;
}

static TestPlan createTestPlan(String domain){
    TestPlan testPlan = new TestPlan("Traffic Generator\t[" + domain + "]");
    testPlan.setProperty(TestElement.TEST_CLASS, TestPlan.class.getName());
    testPlan.setProperty(TestElement.GUI_CLASS, TestPlanGui.class.getName());
    testPlan.setUserDefinedVariables((Arguments) new ArgumentsPanel().createTestElement());
    return testPlan;
}


static File getPropertiesFile(){
    return PROPERTIES_FILE;
}
static File getHomePath(){
    return HOME_PATH;
}