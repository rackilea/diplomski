package com.blazemeter;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.gui.ArgumentsPanel;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.gui.LoopControlPanel;
import org.apache.jmeter.control.gui.TestPlanGui;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.jdbc.config.DataSourceElement;
import org.apache.jmeter.protocol.jdbc.sampler.JDBCSampler;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testbeans.gui.TestBeanGUI;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.threads.gui.ThreadGroupGui;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) throws Exception {

        final String jmeterHome = "c:/apps/jmeter";

        StandardJMeterEngine jmeter = new StandardJMeterEngine();
        JMeterUtils.setJMeterHome(jmeterHome);
        JMeterUtils.loadJMeterProperties(jmeterHome + System.getProperty("file.separator") + "bin"
                + System.getProperty("file.separator") + "jmeter.properties");

        HashTree testPlanTree = new HashTree();

        DataSourceElement jdbcDataSource = new DataSourceElement();
        jdbcDataSource.setName("JDBC Connection Configuration");
        jdbcDataSource.setProperty("dataSource", "foo");
        jdbcDataSource.setProperty("dbUrl", "jdbc:mysql://192.168.99.100:3306/mysql");
        jdbcDataSource.setProperty("driver", "com.mysql.jdbc.Driver");
        jdbcDataSource.setProperty("username", "root");
        jdbcDataSource.setProperty("password", "secret");
        jdbcDataSource.setProperty("poolMax", "0");
        jdbcDataSource.setProperty("connectionAge", "5000");
        jdbcDataSource.setProperty("timeout", "10000");
        jdbcDataSource.setProperty("trimInterval", "60000");
        jdbcDataSource.setProperty(TestElement.TEST_CLASS, DataSourceElement.class.getName());
        jdbcDataSource.setProperty(TestElement.GUI_CLASS, TestBeanGUI.class.getName());

        JDBCSampler jdbcSampler = new JDBCSampler();
        jdbcSampler.setName("JDBC Request");
        jdbcSampler.setProperty("dataSource", "foo");
        jdbcSampler.setProperty("queryType", "Select Statement");
        jdbcSampler.setProperty("query", "select * from help_topic limit 5;");
        jdbcSampler.setProperty(TestElement.TEST_CLASS, JDBCSampler.class.getName());
        jdbcSampler.setProperty(TestElement.GUI_CLASS, TestBeanGUI.class.getName());

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

        TestPlan testPlan = new TestPlan("JMeter JDBC Test Plan");
        testPlan.setProperty(TestElement.TEST_CLASS, TestPlan.class.getName());
        testPlan.setProperty(TestElement.GUI_CLASS, TestPlanGui.class.getName());
        testPlan.setUserDefinedVariables((Arguments) new ArgumentsPanel().createTestElement());

        testPlanTree.add(testPlan);
        HashTree threadGroupHashTree = testPlanTree.add(testPlan, threadGroup);
        threadGroupHashTree.add(jdbcDataSource);
        threadGroupHashTree.add(jdbcSampler);

        SaveService.saveTree(testPlanTree, new FileOutputStream(jmeterHome + System.getProperty("file.separator")
                + "bin" + System.getProperty("file.separator") + "jdbc.jmx"));


        Summariser summer = null;
        String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
        if (summariserName.length() > 0) {
            summer = new Summariser(summariserName);
        }

        String logFile = jmeterHome + System.getProperty("file.separator") +
                "bin" + System.getProperty("file.separator") + "jdbc.jtl";
        ResultCollector logger = new ResultCollector(summer);
        logger.setFilename(logFile);
        testPlanTree.add(testPlanTree.getArray()[0], logger);

        jmeter.configure(testPlanTree);
        jmeter.run();

        System.exit(0);


    }
}