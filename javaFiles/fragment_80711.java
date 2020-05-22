public void insert(String s, int psn) {     
    if(psn < 0 || psn > size)
        throw new IllegalArgumentException();
    Node temp = head; //Save original head
    for(int i=0;i<psn-1;i++)
        temp = temp.next;
    temp.next = new Node(s, temp.next);
    this.size++;
}