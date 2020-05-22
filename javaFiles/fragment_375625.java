for (int s = 0; s < nodeList.getLength(); s++)
{
    Node firstNode = nodeList.item(s);
    NodeList nodes = firstNode.getChildNodes();
    for (int i = 0; i < nodes.getLength(); i++)
    {
        Node node = nodes.item(i);
        //print node info
    }
}