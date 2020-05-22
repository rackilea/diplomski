public static NodeList join(final NodeList... lists) {

    int count = 0;
    for (NodeList list : lists) {
        count += list.getLength();
    }
    final int length = count;

    Node[] joined = new Node[length];
    int outputIndex = 0;
    for (NodeList list : lists) {
        for (int i = 0, n = list.getLength(); i < n; i++) {
            joined[outputIndex++] = list.item(i);
        }
    }
    class JoinedNodeList implements NodeList {
        public int getLength() {
            return length;
        }

        public Node item(int index) {
            return joined[index];
        }
    }

    return new JoinedNodeList();
}