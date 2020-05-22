public class BST {
    static int value[] = {1,2,3,4,5,6};
    public static Node root;

    public static Node insert(int[] num) {
        if (num.length == 0)
                return null;

        return insert(num, 0, num.length - 1);
    }

    public static Node insert(int num[], int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        Node roots = new Node(value[mid]);
        roots.left = insert(value, start, mid - 1);
        roots.right = insert(value, mid + 1, end);

        return roots;
    }

    public static void display(Node node, int level){
        if(node!=null){
            display(node.right, level+1);
            System.out.println("");
            if(node==root)
                System.out.print("Root-> ");
            for(int i=0;i<level&&node!=root;i++)
                System.out.print("             ");
            System.out.print(node.value+"< ");
            display(node.left, level+1);
        }
    }

    public static void main(String args[]){
        display(insert(value), 0);
    }
}