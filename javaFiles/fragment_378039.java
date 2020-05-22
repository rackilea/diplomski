static void visitNodes(List<Node> nodes, String prefix) {
    for (Node child : nodes) {
        if (child instanceof Element) {
            Element e = (Element)child;
            visitNodes(e.childNodes(), e.tagName() + ":");
        } else if (child instanceof TextNode) {
            if (prefix != null) {
                System.out.print(prefix);
            }
            System.out.println(((TextNode)child).text());
        }
    }
}