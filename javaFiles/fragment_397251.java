public static TableRowElement findNearestParentRow(Node node)
{
    Node element = findNearestParentNodeByType(node, "tr");
    if (element != null)
    {
        return element.cast();
    }
    return null;
}

public static Node findNearestParentNodeByType(Node node, String nodeType)
{
    while ((node != null))
    {
        if (Element.is(node))
        {
            Element elem = Element.as(node);

            String tagName = elem.getTagName();

            if (nodeType.equalsIgnoreCase(tagName))
            {
                 return elem.cast();
            }

        }
        node = node.getParentNode();
    }
    return null;
}