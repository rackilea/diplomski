public void printTree(Node n, int level){
  display level number of spaces and print the value held by Node n.
  for(each of the children of n){
    printTree(theChild, level+1)
  }
}