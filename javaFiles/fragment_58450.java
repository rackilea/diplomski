try {

    //Load the XML File
    DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
    domFactory.setNamespaceAware(true);
    DocumentBuilder builder = domFactory.newDocumentBuilder();
    Document configuration = builder.parse("configs.xml");

    //Create an XPath expression
    XPathFactory xpathFactory = XPathFactory.newInstance();
    XPath xpath = xpathFactory.newXPath();
    XPathExpression expr = xpath.compile("//ConfigGroup/ValueString[@Name='Host']/text()");

    //Execute the XPath query
    Object result = expr.evaluate(configuration, XPathConstants.NODESET);
    NodeList nodes = (NodeList) result;

    //Parse the results
    for (int i = 0; i < nodes.getLength(); i++) {
        System.out.println(nodes.item(i).getNodeValue()); 
    }
} catch (ParserConfigurationException e) {
    System.out.println("Bad parser configuration");
    e.printStackTrace();
} catch (SAXException e) {
    System.out.println("SAX error loading the file.");
    e.printStackTrace();
} catch (XPathExpressionException e) {
    System.out.println("Bad XPath Expression");
    e.printStackTrace();
} catch (IOException e) {
    System.out.println("IO Error reading the file.");
    e.printStackTrace();
}