DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
factory.setNamespaceAware(true);
Document doc = factory.newDocumentBuilder().parse(Dupes.class.getResourceAsStream("jsff.xml"));
XPathExpression expr = XPathFactory.newInstance().newXPath().compile("//@id");
Set<String> ids = new HashSet<String>();
NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
int dupes = 0;
for (int i = 0; i < nodes.getLength(); i++) {
    String id = nodes.item(i).getNodeValue();
    if (ids.contains(id)) {
         System.out.format("%s is duplicate\n\n",id);
         dupes++;
    } else {
        ids.add(id);
    }
}
System.out.format("Total ids = %d\nTotal Duplicates = %d", ids.size(), dupes);