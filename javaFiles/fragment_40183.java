Queue<BT> queue = new LinkedList<BT>() ;

public void breadth(BT root) {
    if (root == null)
        return;

    queue.clear();
    queue.add(root);
    int index = 0;
    while(!queue.isEmpty()){
        BT node = queue.remove();
        node.Index = index;
        index++;
        if(node.left != null) queue.add(node.left);
        if(node.right != null) queue.add(node.right);
    }

}