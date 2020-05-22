public static void main(String... args)
throws Exception
{
    String xml = "<A><B><id>0</id></B><B><id>1</id></B></A>";
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    Document doc = dbf.newDocumentBuilder().parse(new InputSource(new StringReader(xml)));

    XPath xPath = XPathFactory.newInstance().newXPath();
    Node result = (Node)xPath.evaluate("A/B[id = '1']", doc, XPathConstants.NODE);

    System.out.println(nodeToString(result));
}

private static String nodeToString(Node node)
throws TransformerException
{
    StringWriter buf = new StringWriter();
    Transformer xform = TransformerFactory.newInstance().newTransformer();
    xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    xform.transform(new DOMSource(node), new StreamResult(buf));
    return(buf.toString());
}