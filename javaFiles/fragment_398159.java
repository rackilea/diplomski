CommandLineOptions options = new CommandLineOptions();
    JCommander jCommander = new JCommander(options, args);

    XmlSuite suite = new XmlSuite();
    suite.setName("MyTestSuite");
    suite.setParameters(options.convertToMap());

    List<XmlClass> classes = new ArrayList<XmlClass>();
    classes.add(new XmlClass("com.some.path.tests.MyTests"));

    XmlTest test = new XmlTest(suite);
    test.setName("MyTests");
    test.setXmlClasses(classes);

    List<XmlSuite> suites = new ArrayList<XmlSuite>();
    suites.add(suite);

    TestNG testNG = new TestNG();
    testNG.setXmlSuites(suites);
    testNG.run();