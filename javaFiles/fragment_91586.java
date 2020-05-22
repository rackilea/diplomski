private Node root;

public Node deleteVal(int val) {
  return deleteRec(root, null, val);
}

private Node deleteRec(Node head, Node prev, int val) {
  if (head == null) {
    return null;
  } 
  if (head.value == val) {
    if (prev != null) { 
      prev.next = head.next; // deleting non-root node
    } else { 
      root = null; // deleting root node  
    }
    return head;
  }
  return deleteRec(head.next, head, val);
}