public void postOrderTraverse(Node root){
    if(root == null){return;}
    Stack<Node> recursionStack = new Stack<Node>();
    Stack<Node> printStack = new Stack<Node>();
    recursionStack.push(root);
    while(!recursionStack.isEmpty()){
        Node node = recursionStack.pop();
        /* Recursion iteration start */
        // According to the recursion we should process left->right->node.
        // Considering that in the loop version we have to reverse the order of invocations,
        // we are processing node->right->left
        printStack.push(node); // node is added to printStack immediately
        // left is added to recursionStack first, but because
        // of the FILO nature of the stack it will be processed last
        if (node.left != null){
            recursionStack.push(node.left);}
        // right is added to recursionStack last, but because
        // of the FILO nature of the stack it will be processed first
        if(node.right != null){
            recursionStack.push(node.right);}
        /* Recursion iteration end */
    }
    // We've processed all the input and now we have reversed
    // history of the prints, processing them in reverse order
    // to receive the actual one
    while(!printStack.empty()){
        System.out.print(printStack.peek());
        printStack.pop();
    }
}