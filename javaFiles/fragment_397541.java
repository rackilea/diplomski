public class Node {

    private int value;
    public Node leftLink;
    public Node rightLink;

    public Node() {

    }

    public Node(int v) {
        this.value = v;
    }

    public int getValue() {
        return value;
    }

    void addNode(Node n) {

        //node tmp = root; // save the current root
        if (getValue() > n.getValue()) {
            if(leftLink == null){
                leftLink = n;
            }else{
                leftLink.addNode(n);
            }
        } else if (getValue() < n.getValue()) {
            if(rightLink == null){
                rightLink = n;
            }else{
                rightLink.addNode(n);
            }
            //root = root.rightLink;
            //addNode(n);
        }
        //root = tmp; // put the root back to its original value

        return;
    }

    void traverseShow() {
        if (leftLink != null) {
            leftLink.traverseShow();
        }
        System.out.println(getValue());
        if (rightLink != null) {
            rightLink.traverseShow();
        }

        return;
    }
}

public class Main {
    public static void main(String[] args) {

        Node rootNode = null;
        int val = 0;
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        String command = "";

        while (loop == true) {
            System.out.println("Please enter a command:");
            System.out.println("A = insert a new value");
            System.out.println("B = display all values");
            System.out.println("C = exit program");
            command = sc.next();
            if (command.equalsIgnoreCase("a")) {
                System.out.println("Enter value: ");
                val = sc.nextInt();
                Node newNode = new Node(val);
                if(rootNode == null){
                    rootNode = new Node(val);
                }else{
                    rootNode.addNode(newNode);
                }
            } else if (command.equalsIgnoreCase("b")) {
                rootNode.traverseShow();
            } else if (command.equalsIgnoreCase("c")) {
                sc.close();
                System.exit(0);
            } else {
                System.out.println("Invalid command! Please try again.");
            }
        }
    }
}