public Node find (int v){
    Node result = null;

    //check for value first
    if (this.value == v) return this;

    //check if you can go any further from the current node
    if(this.left == null && this.right == null) return null;

    //now go right
    result = this.right.find(v);

    //check the node
    if(result != null && result.value == v) return result;

    //if not found return whatever is returned by searching left
    return this.left.find(v);
}