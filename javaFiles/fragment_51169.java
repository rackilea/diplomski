XPath xPathProcessor = XPathFactory.newInstance().newXPath();
xPathProcessor.setNamespaceContext(new NamespaceContext() {
  @Override
  public String getNamespaceURI(String prefix) {
    if(prefix.equals("t")) {
      return "http://www.example.org/test";
    } else {
      return null;  
    }
  }
  @Override public String getPrefix(String namespaceURI) {
    return null; // not used
  }
  @Override
  public Iterator<?> getPrefixes(String namespaceURI) {
    return null; // not used
  }
});
XPathExpression xpathExpression = xPathProcessor.compile("/t:Message/t:Out/t:Personne/t:CodeCivilite");
System.out.println();
Node resultNode = (Node) xpathExpression.evaluate(node, XPathConstants.NODE);