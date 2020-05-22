// Create the new node
LinkedList.Node<String> newNode = new LinkedList.Node<String>();
newNode.data = "bar";
// Since we're prepending, the existing front becomes the next for this node.
newNode.next = list.front;
// This node becomes the front of the list
list.front = newNode;