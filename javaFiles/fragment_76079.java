private static String nodeToString(Node node)
throws TransformerException
{
    StringWriter buf = new StringWriter();
    Transformer xform = TransformerFactory.newInstance().newTransformer();
    xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    xform.transform(new DOMSource(node), new StreamResult(buf));
    return(buf.toString());
}