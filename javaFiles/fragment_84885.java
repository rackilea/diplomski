public static void main(String[] args) throws ParserConfigurationException, SAXException,
        IOException
{
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(new File(args[0]));
    Element root = doc.getDocumentElement();
    //prints root name space
    printAttributesInfo((Node) root);

    NodeList childNodes = root.getChildNodes();
    for (int i = 0; i < childNodes.getLength(); i++)
    {
        printAttributesInfo(childNodes.item(i));
    }
}

public static void printAttributesInfo(Node root)
{
    NamedNodeMap attributes = root.getAttributes();
    if (attributes != null)
    {
        for (int i = 0; i < attributes.getLength(); i++)
        {
            Node node = attributes.item(i);
            if (node.getNodeType() == Node.ATTRIBUTE_NODE)
            {
                String name = node.getNodeName();
                System.out.println(name + " " + node.getNamespaceURI());
            }
        }
    }
}