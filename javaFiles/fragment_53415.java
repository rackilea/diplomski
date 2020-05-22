public void enqueue(String item){
    Node oldLast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    if(oldLast != null)
    {
        oldLast.next = last;
    }
    else
    {
        first = last;
    }
}