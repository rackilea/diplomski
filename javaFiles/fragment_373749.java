public String resolveXPath(File xmlFile, String xpathExpr) throws XPathException, ParserConfigurationException, SAXException, IOException, XPathExpressionException
{
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    // Turn namespace aware on
    factory.setNamespaceAware(true);
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(xmlFile);

    XPathFactory xPathfactory = XPathFactory.newInstance();
    XPath xpath = xPathfactory.newXPath();

    // Set the NamespaceContext        
    xpath.setNamespaceContext(new MyNamespaceContext());


    XPathExpression expr = xpath.compile(xpathExpr);

    return (String) expr.evaluate(doc, XPathConstants.STRING);
}

class MyNamespaceContext implements NamespaceContext {

  private Map<String, String> ns;
  private Map<String, String> nsReverted;

  public MyNamespaceContext() {
    ns = new TreeMap<String, String>();

    // Default namespaces and prefixes according to the documentation
    ns.put(XMLConstants.DEFAULT_NS_PREFIX, XMLConstants.NULL_NS_URI);
    ns.put(XMLConstants.XML_NS_PREFIX, XMLConstants.XML_NS_URI);
    ns.put(XMLConstants.XMLNS_ATTRIBUTE, XMLConstants.XMLNS_ATTRIBUTE_NS_URI);

    // Now our self defined namespace
    ns.put("file", "http://www.example.com/xml/file");


    nsReverted = new TreeMap<String, String>();
    for(Entry<String, String> entry : ns.entrySet()) {
      nsReverted.put(entry.getValue(), entry.getValue());
    }
  }

  @Override
  public String getNamespaceURI(String prefix) {
    if(prefix == null) {
      throw new IllegalArgumentException();
    } 
    final String uri = ns.get(prefix);
    return uri == null ? XMLConstants.NULL_NS_URI : uri;
  }

  @Override
  public String getPrefix(String namespaceURI) {
    if(namespaceURI == null) {
      throw new IllegalArgumentException();
    } 
    return nsReverted.get(namespaceURI);
  }

  @Override
  public Iterator getPrefixes(String namespaceURI) {
    return ns.keySet().iterator();
  }

}