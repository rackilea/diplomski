Node current = start;
do{
  if(current.getData() == i){
    // set the previous's next element
    current.previous.next = current.next;
    // set the next element's previous element
    current.next.previous = current.previous;
    this.size--;
    return current;
  }
  current = current.next;
}while(node != start);
return null;