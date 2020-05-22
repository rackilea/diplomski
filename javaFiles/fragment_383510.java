DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
dbf.setNamespaceAware(true);
Document doc = dbf.newDocumentBuilder().parse("myxml.xml");
XPath xp = XPathFactory.newInstance().newXPath();
XPathExpression xpe = xp.compile("//*[namespace-uri()='urn:schemas-upnp-org:service:WANPPPConnection:1']");
NodeList nl = (NodeList) xpe.evaluate(doc, XPathConstants.NODESET);
for(int i = 0; i < nl.getLength(); i++){
  Element e = (Element) nl.item(i);
  System.out.println(e.getNodeName());
}