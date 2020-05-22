public Node getParentNodeUsingXPath( Element element )
{
    Node parentNode = null;
    XPathFactory xPathFactory = XPathFactory.newInstance();
    XPath xpath = xPathFactory.newXPath();

    String nodeName = element.getNodeName();

    String expression = "//" + nodeName + "/../../..";

    Object obj =    xpath.evaluate(expression, element, XPathConstants.NODE );
    if ( obj != null )
    {
        parentNode = (Node)obj;
    }

    return parentNode;
}