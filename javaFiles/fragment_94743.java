public static void main(String[] args)
        throws TransformerConfigurationException {
    String xmlstring = null;
    String filepath = "E:/C-CDA/MU2_CDA_WORKSPACE/AddingStylesheetTOxml/documentfile.txt";
    final String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
            + "<Emp id=\"1\"><name>Pankaj</name><age>25</age>\n"
            + "<role>Developer</role><gen>Male</gen></Emp>";
    Document doc2 = convertStringToDocument(xmlStr);
    Document doc1 = null;
    try {
        doc1 = addingStylesheet(doc2);
    } catch (ParserConfigurationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    String str = convertDocumentToString(doc1);
    System.out.println(str);
}

private static <ProcessingInstructionImpl> Document addingStylesheet(
        Document doc) throws TransformerConfigurationException,
        ParserConfigurationException {
    ProcessingInstructionImpl pi = (ProcessingInstructionImpl) doc
            .createProcessingInstruction("xml-stylesheet",
                    "type=\"text/xsl\" href=\"mystylesheet.xsl\"");
    Element root = doc.getDocumentElement();
    doc.insertBefore((Node) pi, root);



    //trans.transform(new DOMSource(doc), new StreamResult(new OutputStreamWriter(bout, "utf-8")));
    return doc;

}

private static String convertDocumentToString(Document doc) {
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer;
    try {
        transformer = tf.newTransformer();
        // below code to remove XML declaration
        // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
        // "yes");
        StringWriter writer = new StringWriter();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        String output = writer.getBuffer().toString();
        return output;
    } catch (TransformerException e) {
        e.printStackTrace();
    }

    return null;
}

private static Document convertStringToDocument(String xmlStr) {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;
    Document doc = null;
    try {
        builder = factory.newDocumentBuilder();
        doc = builder.parse(new InputSource(new StringReader(xmlStr)));

    } catch (Exception e) {
        e.printStackTrace();
    }
    return doc;
}