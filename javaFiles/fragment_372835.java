private static String getAttributeValue(String tag, Element element, String attribute) 
{
    NodeList nodes = element.getElementsByTagName(tag);
    //note: you should actually check the list size before asking for item(0)
    //because you asked for ElementsByTagName(), you can assume that the node is an Element
    Element elem = (Element) nodes.item(0);
    return elem.getAttribute(attribute);
}