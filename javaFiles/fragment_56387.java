import java.io.*;

public class TestCase {
    public static void main(String[] args) {
        try {
            if (args.length > 0 && args[0].equals("read")) {
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("File.log")
                    );
                Node root = (Node) ois.readObject();
                ois.close();

                System.out.println("Root value: " + root.getValue());
                for(Node n : root.children())
                    System.out.println("Child: " + n.getValue());

                return;
            }

            Node root = new Node(null, "First");
            root.add(
                    new Node(root, "Second.Child.1"),
                    new Node(root, "Second.Child.2")
                );

            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("File.log")
                );
            oos.writeObject(root);
            oos.close();
        } catch(Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

class Node implements Serializable {
    private static final long serialVersionUID = 2304728943L;
    private Node _parent;
    private Node[] _children;
    private String _value;

    public Node(Node parent, String value) {
        this._parent = parent;
        this._value = value;
        this._children = new Node[2];
    }
    public void add(Node child, Node child2) {
        this._children[0] = child;
        this._children[1] = child2;
    }
    public String getValue() {
        return this._value;
    }
    public Node[] children() {
        return this._children;
    }
    public Node parent() {
        return this._parent;
    }
}