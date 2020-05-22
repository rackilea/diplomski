int recurse(int node, int parent, boolean seenOdd) {
  //if we enter an odd numbered node and we have already 
  //visited another odd-valued one, then we cannot proceed and just return 0
  if (seenOdd && node % 2 == 1) return 0;

  //find out how deep can we go, given the restriction
  //we can visit at most one odd-valued node
  int max = 0;
  for (int next : tree.get(node)) if (next != parent) {
    max = Math.max(max, recurse(next, node, seenOdd | (node % 2 == 1));
  }

  //we add 1 to the answer, because we should 
  //also count the node we are currently at
  return 1 + max;
}