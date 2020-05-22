public void printParents(Node n){
    if(n.left!= null){
        printParents(n.left);
    }
    if(n.right!=null){
        printParents(n.right);
    }
    if(n.parent != null){
        System.out.println("Parent of " + n.value + " is " + n.parent.value);
    }
    else{
        System.out.println("The root node is" + n.value);
    }
}