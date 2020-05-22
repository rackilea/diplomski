OMDocument document = ...
for (Iterator it = document.getDescendants(false); it.hasNext(); ) {
    OMNode node = (OMNode)it.next();
    if (node instanceof OMElement) {
        OMElement element = (OMElement)node;
        element.setNamespace(null, false);  // <-- this actually changes the namespace of the element
        for (Iterator it2 = element.getAllDeclaredNamespaces(); it2.hasNext(); ) {
            it2.next();
            it2.remove();
        }
    }
}