private static void method1() throws XPathExpressionException, FileNotFoundException {
    XPath xpath = XPathFactory.newInstance().newXPath();
    HashMap<String, String> prefMap = new HashMap<String, String>();
    prefMap.put("xs", "http://www.w3.org/2001/XMLSchema");
    prefMap.put("cbi","urn:xmlns:centralbank.ie:anacredit");
    xpath.setNamespaceContext(new SimpleNamespaceContext(prefMap));
    String expression="//xs:simpleType[@name='ReferenceDateEnum']//xs:enumeration";
    NodeList result=(NodeList) xpath.evaluate(expression,new InputSource(new FileInputStream(new File("cprd-schema-v4-1.xsd"))), XPathConstants.NODESET);       
    print(result);
}