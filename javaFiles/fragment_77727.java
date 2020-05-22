final Node parentNode = doc.getDocumentElement();
NodeList childElements = parentNode.getChildNodes();
for (int i = 0; i < childElements.getLength(); ++i)
{
    Node childElement = childElements.item(i);
    if (childElement instanceof Element)
        System.out.println(childElement.getNodeName());
}