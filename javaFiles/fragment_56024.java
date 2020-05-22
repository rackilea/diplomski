else if(id > tail.id)
{
     Node newTail = new Node(id, name, age, gpa, tail, null);
     tail.next = newTail;
     tail = newTail;
     size++;
}