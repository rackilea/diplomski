/* small utility methods to avoid null checks everywhere */
public static Node getNext(Node n) { return n != null ? n.next : null; }

public static boolean isInteger(Node n) {
  return (n != null) && (n.data != null) && (n.data instanceof Integer);
}
public static boolean isAdd(Node n) { 
  return (n != null) && (n.data != null) && n.data.equals("add");
}

/* checks for a match in the 3-node window */
public boolean isMatch(Node[] w) {
  return isInteger(w[0]) && isInteger(w[1]) && isAdd(w[2]);
}

/* Loads the 3-node window with 'n' and the next two nodes on the list */
public void loadWindow(Node[] w, Node n) { 
  w[0] = n; w[1] = getNext(w[0]); w[2] = getNext(w[1]);
}

/* shifts the window down by one node */
public void shiftWindow(Node[] w) { loadWindow(w, w[1]); }

...
Node[] window = new Node[3];
loadWindow( window, node1 );
while (window[2] != null) {
  if (isMatch(window)) { 
    window[0].data = stack[0].data + stack[1].data;
    window[0].next = window[2].next;
    loadWindow(window, window[0]);  // reload the stack after eliminating two nodes
  } else {
    shiftWindow( window );
  }
}