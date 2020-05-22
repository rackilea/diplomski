// check, if the node is part of a TextField
public static boolean checkTextField(Node node) {
    while (node != null) {
        if (node instanceof TextField) {
            return true;
        }
        node = node.getParent();
    }
    return false;
}