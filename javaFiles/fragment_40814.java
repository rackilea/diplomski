private boolean add(E x, BinaryNode<E> currentNode){
  /////// REMOVE
        if (currentNode == null){
            currentNode = new BinaryNode<>(x);
            size++;
            return true;
        }
  ///////