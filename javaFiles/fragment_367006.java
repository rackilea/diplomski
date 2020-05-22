public void insert(T element) 
{
    Node node = new Node(element);
    Node currentNode = head;
    Node previous = null;

    // loop to find the insertion point.
    while (currentNode != null && node.Data.compareTo(currentNode.data) >= 0)
    {
        previous = currentNode;
        currentNode = currentNode.next;
    }        

    // Insert the item between the previous node and the current node.

    // This node's next pointer references the current node.
    node.next = currentNode;

    if (previous == null)
    {
        // Either the list is empty,
        // or the new node is smaller than the head.
        // This node becomes the head.
        head = node;
    }
    else
    {
        // otherwise, the previous node's next pointer
        // references the current node.
        previous.next = node;
    }
    ++numberOfNodes;
}