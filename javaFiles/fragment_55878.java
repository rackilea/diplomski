Node fileNode = filelist.item(o);
for (Node child = fileNode.getFirstChild(); child != null; child = child.getNextSibling()) {
    if (child.getNodeType() == Node.ELEMENT_NODE) {
        switch (child.getNodeName()) {
            case "a":
                tagA = child.getTextContent();
                break;
            case "b":
                tagB = child.getTextContent();
                break;
            case "c":
                tagC = child.getTextContent();
                break;
            default:
                // ignore
        }
    }
}