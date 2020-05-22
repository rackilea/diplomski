private void add(Node cur, int data) {
  if (cur.next != null) {
    add(cur.next, data);      
  } else {
    cur.next = new Node(data, null);
  }
}

public linkedIt2 insert(int data) {
  if (this.head == null) {
     this.head = new Node(data, null);
  } else {
     add(this.head, data);
  }
  length++;
  return this;
}