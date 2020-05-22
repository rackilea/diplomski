public void add(Node newNode)
{
    // assigning first Node
    if (head == null){
        head = newNode;
        rear = newNode;
        return;
    }

    // since first Node assigned, use rear pointer for assignment
    rear.next=newNode;
    rear = newNode;
}