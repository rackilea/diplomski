public class Node {
    private String label;
    private List<Node> children = new ArrayList<>(); // to avoid checks for null

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public List<Node> getChildren() {
        return children;
    }
    public void setChildren(List<Node> children) {
        this.children = children;
    }
}

class Converter {
    public List<Node> fromCsvFile(String filename) throws IOException {
        Node root = new Node();

        BufferedReader input = new BufferedReader(new FileReader(filename));
        String[] entry;

        String line = input.readLine();
        while (line != null) {
            entry = line.split(",");

            // find or create
            Node node = findByLabel(root, entry[0]);
            if (node == null) {
                // top level
                node = new Node();
                node.setLabel(entry[0]);
                root.getChildren().add(node);
            }

            // add child
            Node child = new Node();
            child.setLabel(entry[1]);
            node.getChildren().add(child);

            // next line
            line = input.readLine();
        }

        return root.getChildren();
    }

    public Node findByLabel(Node node, String label) {
        if (label.equals(node.getLabel())) {
            return node;
        }

        for (Node child : node.getChildren()) {
            // recursion
            Node found = findByLabel(child, label);
            if (found != null) {
                return found;
            }
        }

        return null;
    }
}