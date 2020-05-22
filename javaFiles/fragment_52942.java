Queue<Node> currentLevel = new ArrayDeque<Node>();
if (root != null) currentLevel.add(root);
while (true) {
    Node node = currentLevel.poll();
    if (node == null) break;
    /* node is the leftmost on its level */
    Queue<Node> nextLevel = new ArrayDeque<Node>();
    do {
        if (node.leftChild != null) nextLevel.add(node.leftChild);
        if (node.rightChild != null) nextLevel.add(node.rightChild);
        node = currentLevel.poll();
    } while (node != null);
    currentLevel = nextLevel;
}