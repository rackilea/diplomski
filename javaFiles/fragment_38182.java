private static double getGlobalX(Node node) {
    if (node == null) {
        return 0.0;
    }
    double parentGlobalX = getGlobalX(node.getParent());
    return node.getLayoutX() - parentGlobalX;
}

private static double getGlobalY(Node node) {
    if (node == null) {
        return 0.0;
    }
    double parentGlobalY = getGlobalY(node.getParent());
    return parentGlobalY - node.getLayoutY();
}