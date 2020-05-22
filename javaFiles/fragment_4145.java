public class Node {
    String value;
    static counter; 
    int timestamp;

    public Node(String v) {
        value = v;
        counter++;
        timestamp = counter;
    }
}