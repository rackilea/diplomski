public E peek(){
  if(empty()) return null;

  int top = list.size()-1;
  return list.get(top);
}