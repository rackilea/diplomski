private boolean sameTree(ArrayNTree<T> xpto) {
    if(this.data != xpto.data || this.size != xpto.size)
        return false;
    for(int i = 0; i<this.children.length: i++){
        if(!this.children[i].equals(xpto.children[i]))
             return false;
    }
    return true;
}