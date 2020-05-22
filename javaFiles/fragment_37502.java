private static boolean modifiedInorderTraversal(Node newRoot, Node target){     
    boolean foundIt = false;

    if(newRoot.leftPointer != null){
        foundIt = modifiedInorderTraversal(newRoot.leftPointer, target);
        if(foundIt){
            System.out.println("Target found in left subtree");
            return true;
        }
    }

    System.out.println("searching: "+newRoot.value);
    if(newRoot == target){
        System.out.println("Target found at current node!");
        return true; //the target is this node!
    } 

    if(newRoot.rightPointer != null){
        foundIt = modifiedInorderTraversal(newRoot.rightPointer, target);
        if(foundIt){
            System.out.println("Target found in right subtree!");
            return true;
        }
    }

    System.out.println("Not found below root "+newRoot.value);
    return false; //the target is in neither subtree, and is not the root :-(
}

//My tree:
//      a
//    /   \
//    b    c
//   /\    /\
//  d e   f  g
public static void main(String[] arg){
    Node d = new Node(null,null,"d");
    Node e = new Node(null,null,"e");
    Node f = new Node(null,null,"f");
    Node g = new Node(null,null,"g");

    Node b = new Node(d,e,"b");
    Node c = new Node(f,g,"c");

    Node a = new Node(b,c,"a");

    System.out.println("Searching for f");
    if(modifiedInorderTraversal(a, f)){
        System.out.println("Success!");
    }

    System.out.println("---------------------------------");

    System.out.println("Searching for q");
    Node q = new Node(null,null,"q");
    if(modifiedInorderTraversal(a, q)){
        System.out.println("Shouldn't make it here...");
    } else{
        System.out.println("Didn't find q, as we shouldn't");
    }
}

private static class Node {
    public Node(Node left, Node right, String value){
        leftPointer = left;
        rightPointer = right;
        this.value = value;
    }
    Node leftPointer;
    Node rightPointer;
    String value;
}