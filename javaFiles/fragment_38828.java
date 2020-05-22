ExtentReports extent = new ExtentReports(Use your config);
    ExtentTest test = extent.startTest("Hello","Yeah"); 

    extent.loadConfig(ExtentReports.class, "extent-config.xml");

    test.log(LogStatus.PASS, "Before Step details");

    ExtentTest child1 = extent.startTest("Child 1");
    child1.log(LogStatus.INFO, "Info");
    child1.log(LogStatus.PASS, "Pass");

    ExtentTest child2 = extent.startTest("Child 2");
    child2.log(LogStatus.INFO, "Info");
    child2.log(LogStatus.PASS, "Pass");

    test.appendChild(child1).appendChild(child2);

    test.log(LogStatus.PASS, "After Step details");

    extent.endTest(test);
    extent.flush();     
    extent.close();