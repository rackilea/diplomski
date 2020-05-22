public static void main (String args[]) {
    HashMap<Node, Set<Node>> nodes = new HashMap<>();
    File file = new File("E:/test.txt");

    try (Stream<String> stream = Files.lines(file.toPath())) {
        stream.forEach((line) -> {
            String parts[] = line.split(";");
            Node node = new Node(parts);
            Node parent = new Node(parts[1]);

            nodes.putIfAbsent(parent, new HashSet<>());
            nodes.putIfAbsent(node, new HashSet<>());
            nodes.get(parent).add(node);
        });
    } catch (Exception e) {
        e.printStackTrace();
    }
    calculateSize(nodes, new Node(" "));
    traverse(nodes, new Node(" "));

}

public static void traverse(HashMap<Node, Set<Node>> nodes, Node root) {
    System.out.println(root);
    for (Node child : nodes.get(root)) {
        traverse(nodes, child);
    }
}

public static int calculateSize(HashMap<Node, Set<Node>> nodes, Node root) {
    int size = root.getSize();
    for (Node child : nodes.get(root)) {
        size += calculateSize(nodes, child);
    }
    root.setSize(size);
    return size;
}

public static class Node {
    private String id = " ";
    private String type= " ";
    private String name = " ";
    private int size = 0;
    private String classification = " ";
    private int checksum = 0;

    public Node (String[] parts) {
        this.id = parts[0];
        this.name = parts[2];
        this.type = parts[3];
        this.classification = parts[5];
        if (this.type.equals("file")) {

            this.size = Integer.parseInt(parts[4]);
            this.checksum = Integer.valueOf(parts[6]);
        }
    }

    public Node (String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        if (name.equals(" ")) return "Root";
        String toString = (name.equals(" ")) ? "" : String.format("name = %s", name);
        toString += (type.equals(" ")) ? "" : String.format(", type = %s", type);
        toString += String.format(", size = %d", size);
        toString += (classification.equals(" ")) ? "" : String.format(", classification = %s", classification);
        toString += String.format(", checksum = %d", checksum);
        return toString;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Node) {
            return ((Node) o).id.equals(this.id);
        } else if (o instanceof String) {
            return o.equals(this.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }
}