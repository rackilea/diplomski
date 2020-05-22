DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
DocumentBuilder b = f.newDocumentBuilder();
Document d = b.parse(...);

// Find all nodes with the attribute of type equal to `t1`
// You could use //*/a[@type='t1'] if you wanted to narrow it down
// This find ALL matches through out the document...
String expression = "//*[@type='t1']";
XPath xPath = XPathFactory.newInstance().newXPath();
Object result = xPath.compile(expression).evaluate(d, XPathConstants.NODESET);

NodeList nodes = (NodeList) result;