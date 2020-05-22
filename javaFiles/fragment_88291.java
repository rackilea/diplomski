int findSum(int[] tree , int at_node){
    if(at_node >= length(tree))
        return 0 //end of the tree, quit recursive search

    //maximum-path including node is the path with the greatest sum that includes either the left or right child of the node.
    return max(findSum(tree , leftChild(at_node)) , 
                  findSum(tree , rightChild(at_node)) + tree[at_node]
}