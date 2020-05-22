public void visitNode(Node node) {
    if (node instanceof Element) {
        Element e = (Element)node;
        System.out.println(e.tagName());
        for (Node child : e.childNodes()) {
            this.visitNode(child);
        }
    } else if (node instanceof TextNode) {
        System.out.println(((TextNode)node).text());
    }
}