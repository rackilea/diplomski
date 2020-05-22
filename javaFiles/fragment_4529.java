InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.xml");
Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(input));
XPath xpath = XPathFactory.newInstance().newXPath();
String url = (String) xpath.compile("//config//jdbc//url").evaluate(document, XPathConstants.STRING);
String driver = (String) xpath.compile("//config//jdbc//driver").evaluate(document, XPathConstants.STRING);
String username = (String) xpath.compile("//config//jdbc//username").evaluate(document, XPathConstants.STRING);
String password = (String) xpath.compile("//config//jdbc//password").evaluate(document, XPathConstants.STRING);
// ...