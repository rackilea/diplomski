String namespace = "http://com";
String prefix = "ns2";
// Upgrade the DOM level 1 to level 2 with the correct namespace
Element originalDocumentElement = document.getDocumentElement();
Element newDocumentElement = document.createElementNS(namespace, originalDocumentElement.getNodeName());
// Set the desired namespace and prefix
newDocumentElement.setPrefix(prefix);
// Copy all children
NodeList list = originalDocumentElement.getChildNodes();
while(list.getLength()!=0) {
    newDocumentElement.appendChild(list.item(0));
}
// Replace the original element
document.replaceChild(newDocumentElement, originalDocumentElement);