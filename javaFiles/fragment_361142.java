for (int i = 0; i < list.getLength(); ++i)
{
    Node n = list.item(i);
    if (n.getType().equals(Node.ELEMENT_NODE))
    {
        n.getNodeName();
    }
}