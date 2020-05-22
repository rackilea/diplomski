Node buildTree(int N) {
  // A layer N tree may be empty (if N is more than the max desired layer number)
  if (L >= maxLayerNumber) {
    return new Node with no children
  }
  // ... or else it's a node with layer number N and K subtrees with layer number N+1
  Let C be an initially empty list of children
  for i = 1 to K {
    Let c = buildTree(N + 1)  
    Add c to C
  }
  return new Node with layer number N and children C
}