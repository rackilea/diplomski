void traverse(TrieNode current, String prefix){
  // do what you need with the key...
  String currentValue = current.getKey();
  // do what you need if leaf
  if (current.getIsLeaf()) {
    // do operations
  }
  for (TrieNode temp : current.getChildren()) {
      traverse(temp);
   }
}