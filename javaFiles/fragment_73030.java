class Data {
    private final int intValue;
    private final String strValue;
    private final double doubleValue;
}

class Node {
    private final Data data;
    private Node next;

    public Node(Data data) {
        this.data = data;
        this.next = null;
    }
}