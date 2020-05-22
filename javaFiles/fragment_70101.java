class Main {
    public static void main(String[] args) {
        Node head = new Node(200, new Node(25, new Node(473, new Node(23, new Node(390, null)))));

        System.out.println("Example 1 (correct):");
        System.out.println(head);
        head = sort(head);
        System.out.println(head);

        head = new Node(200, new Node(25, new Node(473, new Node(23, new Node(390, null)))));

        System.out.println("\nExample 1 (incorrect):");
        System.out.println(head);
        sort(head);
        System.out.println(head);

        head = new Node(900, new Node(25, new Node(473, new Node(23, new Node(390, null)))));

        System.out.println("\n\nExample 2 (correct):");
        System.out.println(head);
        head = sort(head);
        System.out.println(head);

        head = new Node(900, new Node(25, new Node(473, new Node(23, new Node(390, null)))));

        System.out.println("\nExample 2 (incorrect):");
        System.out.println(head);
        sort(head);
        System.out.println(head);

        head = new Node(1, new Node(25, new Node(473, new Node(23, new Node(390, null)))));
        System.out.println("\n\nExample 3 (accidentally works, because the old head is still the new head):");
        System.out.println(head);
        sort(head);
        System.out.println(head);
    }

    static Node getMiddle(Node node) {
        Node fastptr = node.link; 
        Node slowptr = node; 

        while (fastptr != null) { 
            fastptr = fastptr.link; 

            if (fastptr != null) { 
                slowptr = slowptr.link;
                fastptr = fastptr.link; 
            }
        } 

        return slowptr; 
    }

    static Node merge(Node left, Node right) { 
        Node temp = new Node(-1, null);
        Node curr = temp;

        while (left != null && right != null) {
            if (left.data < right.data) {
                curr.link = left;
                left = left.link;
            }
            else {
                curr.link = right;
                right = right.link;
            }

            curr = curr.link;
        }

        curr.link = left == null ? right : left;
        return temp.link;
    }

    static Node sort(Node node) {
        if (node == null || node.link == null) {
            return node; 
        }

        Node middle = getMiddle(node);
        Node next = middle.link;
        middle.link = null;
        return merge(sort(node), sort(next));
    }
}

class Node {
    public int data;
    public Node link;

    public Node(int data, Node link) {
        this.data = data;
        this.link = link;
    }

    public String toString() {
        return this.data + (this.link != null ? "->" + this.link : "");
    }
}