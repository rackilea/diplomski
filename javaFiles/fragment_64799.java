for(int i = 0; i<size; i++){
  if((current.getData()).equals(item)){
     index = i; //this will be the index of the item to be removed
  }
  current = current.next;
}