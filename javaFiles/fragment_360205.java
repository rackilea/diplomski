Person temp;
if (child1 != null) {
  temp = child1.depthFirstSearch(name, maxGeneration-1);
  if (temp != null)
    return temp; // found the node, just return
}
// otherwise the following code will execute
if (child2 != null) {
  temp = child2.depthFirstSearch(name, maxGeneration-1);
  if (temp != null)
    return temp; // found the node, just return
}
// didn't find node under either child
return null;