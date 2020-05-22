class Converter {
    public List<Node> fromCsvFile(String filename) throws IOException {
        Node root = new Node();
        Map<String, Node> existingNodes = new HashMap<>();

        BufferedReader input = new BufferedReader(new FileReader(filename));
        String[] entry;

        String line = input.readLine();
        while (line != null) {
            entry = line.split(",");

            // find or create
            Node node = existingNodes.get(entry[0]);
            if (node == null) {
                // new top level node
                node = new Node();
                node.setLabel(entry[0]);
                root.getChildren().add(node);
                existingNodes.put(entry[0], node);
            }

            // add child
            Node child = new Node();
            child.setLabel(entry[1]);
            node.getChildren().add(child);
            existingNodes.put(entry[1], child);

            // next line
            line = input.readLine();
        }

        return root.getChildren();
    }
}