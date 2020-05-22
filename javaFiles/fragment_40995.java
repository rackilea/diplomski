public void execute(InputStream sourceFile, OutputStream targetFile) throws StreamTransformationException
{
    //Parse the source xml file
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = null;
    try
    {
        dBuilder = dbFactory.newDocumentBuilder();
    } 
    catch (ParserConfigurationException e)
    {
        throw new StreamTransformationException(e);
    }
    Document doc = null;
    try
    {
        doc = dBuilder.parse(sourceFile);
    }
    catch (SAXException e) 
    {
        throw new StreamTransformationException(e);
    } 
    catch (IOException e) 
    {
        throw new StreamTransformationException(e);
    }
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
    Transformer transformer = null;
    try
    {
        transformer = transformerFactory.newTransformer();
    }
    catch (TransformerConfigurationException e)
    {
        throw new StreamTransformationException(e);
    }
    DOMSource domSource = new DOMSource(doc);
    StreamResult result = new StreamResult(targetFile);
    try
    {
        transformer.transform(domSource, result);
    } 
    catch (TransformerException e)
    {
        throw new StreamTransformationException(e);
    }

}