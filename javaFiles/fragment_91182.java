Document doc   = getDocument();
XPath    xpath = XPathFactory.newInstance().newXPath();
NodeList nodeList;

nodeList = (NodeList) xpath.evaluate("//name[.='tim']/..", doc, XPathConstants.NODESET);
for(int i = 0; i < nodeList.getLength(); i++) {
    Node contact = nodeList.item(i);
    System.out.println("Name: " + ((Node)xpath.evaluate("name", contact, XPathConstants.NODE)).getTextContent());
    System.out.println("Address: " + ((Node)xpath.evaluate("primary_address", contact, XPathConstants.NODE)).getTextContent());
}