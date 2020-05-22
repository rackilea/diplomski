Collection items = ...
Iterator itr = items.iterator();
while(itr.hasNext()) {
  Object o = itr.next();
  boolean condition = ...
  if(condition) {
    itr.remove();
  }
}