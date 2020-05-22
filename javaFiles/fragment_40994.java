public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
    try { 
        TestIntegrate t = new TestIntegrate();
        t.execute("C:/Users/xyz/workspace/TEST_2.xml", "C:/Users/xyz/workspace/OutputFile.xml");
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}


public void execute(String sourceFile, String targetFile) throws ParserConfigurationException, SAXException, IOException, TransformerException
{
    //Parse the source xml file
    File source = new File(sourceFile);
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(source);
    doc.getDocumentElement().normalize();

    NodeList taxNodes = doc.getElementsByTagName("Tax");

    //Loop through tax nodes and move inner nodes => start at the end as we remove the tax nodes afterwards
    for(int i = taxNodes.getLength() - 1; i > -1; i--)
    {
        Element taxNode = (Element) taxNodes.item(i);
        Node parent = taxNode.getParentNode();

        while (taxNode.hasChildNodes()) 
        {
            parent.insertBefore(taxNode.getFirstChild(), taxNode);
        }

        taxNodes.item(i).getParentNode().removeChild(taxNodes.item(i));
    }

    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    DOMSource domSource = new DOMSource(doc);
    StreamResult result = new StreamResult(new File(targetFile));
    transformer.transform(domSource, result);

}