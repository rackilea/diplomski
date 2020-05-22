public static void printPreOrder(Node root) {

            if (root!=null){
                System.out.print(" " + root.data);
                printPreOrder(root.left); 
                printPreOrder(root.right);
            }
        }
    }