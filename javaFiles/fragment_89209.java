private Node root;

public boolean insert(Student s) {
    return insert(this.root, s);
}

private boolean insert(Node n, Student s) {

    if (this.root == null) {
        this.root = n;
        return n == null;  // did you really insert something? 
    }

    if (n == null) return false;

    boolean inserted = false;

    if(s.getLastName().compareTo(n.data) <= 0) { // Compare same names
        if (n.left == null) {
            n.left = new Node(s); // Not sure what this looks like
            return true;       // Inserted a node
        }
        inserted = insert(n.left,s);
    } else if(s.getLastName().compareTo(n.data) > 0) {
        if (n.right == null) {
            n.right = new Node(s); // Not sure what this looks like
            return true;       // Inserted a node
        }
        inserted = insert(n.right,s);
    } else { // Should never get here 
        // Not actually an error
        // System.out.println("Error!!!!!");
    }
    return inserted;
}