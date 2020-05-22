public Node findNode(Node n, String s) {
    if (n.name == s) {
        return n;
    } else {
        for (Node child: n.children.values()) {
            Node result = findNode(child, s);
            if (result != null) {
                return result;
            }
        }
    }
    return null;
}