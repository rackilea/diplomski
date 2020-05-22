public class Node() {
    private int id;
    private String data;
    private Node parent;
    private List<Node> children;

    // Constructor, getters, etc..

    public String getFullId() {
        if (parent == null) {
            return String.valueOf(id) {
        }
        return parent.getFulld() + "." + id;
    }
}