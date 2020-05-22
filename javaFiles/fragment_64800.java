for(int i = index; i <= size; index++){
  if(i < size){
    current.setData(current.next.getData());
    current = current.next;
  }
  ...