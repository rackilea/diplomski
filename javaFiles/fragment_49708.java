public E pop(){
  if(empty()) throw new NoSuchElementException();

  int top = list.size()-1;
  return list.remove(top);
}