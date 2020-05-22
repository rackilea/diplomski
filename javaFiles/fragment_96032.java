public static List<Node> fromCsvFile(String filename) throws IOException {
    Node root = new Node();
    Map<String, Node> existingNodes = new HashMap<>();

    try (BufferedReader input = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = input.readLine()) != null) {
            String[] elements = line.split("\\s*,\\s*");
            for (int i = elements.length; i > 1; i--) {
                addPair(elements[i - 1], elements[i - 2], root, existingNodes);
            }
        }
    }

    return root.getChildren();
}

private static void addPair(String parentName, String childName, Node root, Map<String, Node> existingNodes) {
    if (!existingNodes.containsKey(childName)) {
        // find or create
        Node node = existingNodes.get(parentName);
        if (node == null) {
            // new top level node
            node = new Node();
            node.setLabel(parentName);
            root.addChild(node);
            existingNodes.put(parentName, node);
        }

        // add child
        Node child = new Node();
        child.setLabel(childName);
        node.addChild(child);
        existingNodes.put(childName, child);
    }
}