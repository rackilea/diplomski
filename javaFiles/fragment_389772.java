static <T extends Node<T>> void addNewNeighbors1a(T node, T newNode)
{
  node.addNeighbor(newNode);
  print("Add city to node", node.neighbors());
}

static <T extends Node<T>> void addNewNeighbors2(T node, T newNode)
{
  node.addNeighbor(newNode);
  print("Add concrete node to node", node.neighbors());
}