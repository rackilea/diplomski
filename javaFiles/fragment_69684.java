public final String getElementValue(Node elem) {
    Node child;
    if (elem != null) {
        if (elem.hasChildNodes()) {
            for (child = elem.getFirstChild(); child != null; child = child.getNextSibling()) {
                if ((child.getNodeType() == Node.TEXT_NODE) || (child.getNodeType() == Node.ELEMENT_NODE) ) {
                    return child.getNodeValue();
                }
            }
        }
    }
    return "";
}