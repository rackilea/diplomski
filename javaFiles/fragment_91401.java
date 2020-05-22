public BinaryTreeNode<String> readTree(Scanner scanner) {

    if (scanner.hasNextLine()) {
        ...
        return new BinaryTreeNode<String>(data, left, right);
    }

    throw new IllegalStateException("No data found to create a BinaryTreeNode");
}