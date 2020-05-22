// This method returns all the child elements of the given Parent tag
public static void getAllChildTags(String strXmlFile, String strParentTag) {

    // Parse Xml File
    parseXmlFile(strXmlFile);

    NodeList flowList = dom.getElementsByTagName(strParentTag);

    for (int i = 0; i < flowList.getLength(); i++)
    {
        NodeList childList = flowList.item(i).getChildNodes();

        for (int j = 0; j < childList.getLength(); j++)
        {
            Node child = childList.item(j);
            if (!child.getNodeName().equals("#text"))
            {
                System.out.println(child.getNodeName() + " -> " + childList.item(j).getTextContent());
            }
        }
    }
}