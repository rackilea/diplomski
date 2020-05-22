List<String> al = new Arraylist<String>();
 Iterator<String> itr = al.iterator();
 while(itr.hasNext()){
   itr.next();
   itr.remove();
 }