XmlSuite suite = new XmlSuite();
suite.setParameters(suiteParameters - you can use a map(key,value));
classes = new ArrayList<XmlClass>();
classes.add(new XmlClass(fullClassName));
--here add all the required test class to classes object.
test.setXmlClasses(classes);
List<XmlSuite> suites = new ArrayList<XmlSuite>();
suites.add(suite);
TestNG tng = new TestNG();
tng.setXmlSuites(suites);
tng.run();