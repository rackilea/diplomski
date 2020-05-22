public interface Tree<K, V> {
       /**
     * Find the nth smallest element in the tree
     * 
     * @param nth
     * @return nth smallest element in the tree
     */
    public K findSmallest(int nth);
}

@Override


 public K findSmallest(int nth) {
    Node iterator = root;
    return traverseLeftParentRight(iterator, new AtomicInteger(nth));
  }



private K traverseLeftParentRight(Node iterator, AtomicInteger nth) {
    if (null == iterator || nth.get() == 0) {
      return null;
    }
    K value = traverseLeftParentRight(iterator.left, nth);
    // Found in the left subtree itself
    if (null != value) {
      return value;
    }
    if (nth.decrementAndGet() == 0) {
      return iterator.key;
    }
    // Check in the right subtree
    return traverseLeftParentRight(iterator.right, nth);
  }



  public static void main(String[] args) {
      // Create a BST
      Comparator comparator = integerComparator();
      Tree tree = new BinarySearchTree(comparator);
      fillData(tree);
      System.out.println("4thlest element " + tree.findSmallest(4));
   }

private static void fillData(Treetree) {
  tree.put(5, "value-5");
  for (int i = 0; i <= 10; i++) {
   tree.put(i, "value-" + i);
  }
 }