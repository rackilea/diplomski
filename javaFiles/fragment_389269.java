public static void main(String[] args) {

    /**
     * Get the number of hosts (for example from the arguments, 
     * or from a file, or from System.getenv, etc...)
     */
    Integer numberOfHosts = this.getNumberOfHosts();

    // Creating a new Suite
    XmlSuite suite = new XmlSuite();

    for (Integer i = 1; i <= numberOfHosts; i++) {

      // Creating a new Test
      XmlTest test = new XmlTest(suite);

      // Set Test name
      test.setName("test-number-" + i);

      // New list for the parameters
      Map<String, String> testParams = new HashMap<String, String>();

      // Add parameter to the list
      testParams.put("host", String.valueOf(i));

      // Add parameters to test
      test.setParameters(testParams);

      // New list for the classes
      List<XmlClass> classes = new ArrayList<XmlClass>();

      // Putting the classes to the list
      classes.add(new XmlClass("firsttestngpackage.Test5"));

      // Add classes to test
      test.setClasses(classes);

    }

    // New list for the Suites
    List<XmlSuite> suites = new ArrayList<XmlSuite>();

    // Add suite to the list
    suites.add(suite);

    // Creating the xml
    TestListenerAdapter tla = new TestListenerAdapter();
    TestNG tng = new TestNG();
    tng.setXmlSuites(suites);
    tng.addListener(tla);
    tng.run();

  }