public boolean add(E x){
    if( root == null ) {
      root = new BinaryNode<>(x);
      size++;
      return true;
    }  else
      return this.add(x, root);
}