class Node {

    public int val;
    public String data;
    public ArrayList<Node> children;

    public Node(int val, String data) {
        this.val = val;
        this.data = data;
        this.children = new ArrayList<Node>();
    }

}