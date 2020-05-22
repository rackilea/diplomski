Set<Node> visitedNodes = new HashSet<Node>();

//...
if ( !visitedNodes.contains(children[i]) ) {
   stack.push(children[i]);
   visitedNodes.add(children[i]);
}