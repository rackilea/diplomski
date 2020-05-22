else if( id < head.id)
{
     Node newHead = new Node(id, name, age, gpa, null, head);
     head.prev = newHead;
     head = newHead;
     size ++;
}