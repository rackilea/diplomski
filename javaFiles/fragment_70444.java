import kg.apc.jmeter.perfmon.PerfMonCollector;
import kg.apc.jmeter.vizualizers.PerfMonGui;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.gui.ArgumentsPanel;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.gui.LoopControlPanel;
import org.apache.jmeter.control.gui.TestPlanGui;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.testelement.property.CollectionProperty;
import org.apache.jmeter.testelement.property.StringProperty;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.threads.gui.ThreadGroupGui;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

import java.io.FileOutputStream;

public class JMeterWithPerfMon {

    public static void main(String[] args) throws Exception {

        String jmeterHome = "/path/to/your/jmeter/installation";

        StandardJMeterEngine jmeter = new StandardJMeterEngine();

        JMeterUtils.setJMeterHome(jmeterHome);
        JMeterUtils.loadJMeterProperties(jmeterHome + "/bin/jmeter.properties");
        JMeterUtils.initLocale();

        HashTree testPlanTree = new HashTree();

        HTTPSamplerProxy examplecomSampler = new HTTPSamplerProxy();
        examplecomSampler.setDomain("example.com");
        examplecomSampler.setPort(80);
        examplecomSampler.setPath("/");
        examplecomSampler.setMethod("GET");
        examplecomSampler.setName("Open example.com");
        examplecomSampler.setProperty(TestElement.TEST_CLASS, HTTPSamplerProxy.class.getName());
        examplecomSampler.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());

        PerfMonCollector perfMonCollector = new PerfMonCollector();
        perfMonCollector.setName("PerfMon Metrics Collector");
        perfMonCollector.setProperty("filename", "perfmon.jtl");
        CollectionProperty metricConnections = new CollectionProperty();
        metricConnections.setName("metricConnections");
        CollectionProperty cpu = new CollectionProperty();
        cpu.setName("cpu");
        cpu.addProperty(new StringProperty("host", "localhost"));
        cpu.addProperty(new StringProperty("port", "4444"));
        cpu.addProperty(new StringProperty("metric", "CPU"));
        cpu.addProperty(new StringProperty("metricParam", ""));
        metricConnections.addProperty(cpu);
        perfMonCollector.setProperty(metricConnections);
        perfMonCollector.setProperty(TestElement.TEST_CLASS, PerfMonCollector.class.getName());
        perfMonCollector.setProperty(TestElement.GUI_CLASS, PerfMonGui.class.getName());

        LoopController loopController = new LoopController();
        loopController.setLoops(1);
        loopController.setFirst(true);
        loopController.setProperty(TestElement.TEST_CLASS, LoopController.class.getName());
        loopController.setProperty(TestElement.GUI_CLASS, LoopControlPanel.class.getName());
        loopController.initialize();

        ThreadGroup threadGroup = new ThreadGroup();
        threadGroup.setName("Example Thread Group");
        threadGroup.setNumThreads(1);
        threadGroup.setRampUp(1);
        threadGroup.setSamplerController(loopController);
        threadGroup.setProperty(TestElement.TEST_CLASS, ThreadGroup.class.getName());
        threadGroup.setProperty(TestElement.GUI_CLASS, ThreadGroupGui.class.getName());

        TestPlan testPlan = new TestPlan("Create JMeter Script From Java Code");
        testPlan.setProperty(TestElement.TEST_CLASS, TestPlan.class.getName());
        testPlan.setProperty(TestElement.GUI_CLASS, TestPlanGui.class.getName());
        testPlan.setUserDefinedVariables((Arguments) new ArgumentsPanel().createTestElement());

        testPlanTree.add(testPlan);
        HashTree threadGroupHashTree = testPlanTree.add(testPlan, threadGroup);
        threadGroupHashTree.add(perfMonCollector);
        threadGroupHashTree.add(examplecomSampler);

        SaveService.saveTree(testPlanTree, new FileOutputStream(jmeterHome + "/bin/test.jmx"));

        Summariser summer = null;
        String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
        if (summariserName.length() > 0) {
            summer = new Summariser(summariserName);
        }

        String logFile = jmeterHome + "/bin/result.jtl";
        ResultCollector logger = new ResultCollector(summer);
        logger.setFilename(logFile);
        testPlanTree.add(testPlanTree.getArray()[0], logger);

        jmeter.configure(testPlanTree);
        jmeter.run();

        System.exit(0);
    }
}