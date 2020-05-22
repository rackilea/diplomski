CopyOnWriteArrayList<String> al = new CopyOnWriteArrayList<String>();
  al.add("2");
  Iterator<String> itr = al.iterator();
  while(itr.hasNext()){
  itr.next();
  al.add("3");
 }