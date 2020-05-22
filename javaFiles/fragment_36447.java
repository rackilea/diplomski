private Node<T> insert(Node<T> p, T toInsert){
      if (p == null)
         return new Node<T>(toInsert);

      if (compare(toInsert, p.data) == 0)
        return p;

      if (compare(toInsert, p.data) < 0)
         p.left = insert(p.left, toInsert);
      else
         p.right = insert(p.right, toInsert);
      return p;
   }