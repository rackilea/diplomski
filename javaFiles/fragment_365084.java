public static IntNode insertNode(IntNode head, IntNode node)
{
    node.link = null;
    if (head == null) {
        return node;
    }
    IntNode root = head;
    while (root.link != null) {
        root = root.link;
    }
    root.link = node;
    return head;
}