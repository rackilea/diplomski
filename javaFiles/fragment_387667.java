List<String> mylist = new ArrayList<String>();
mylist.add("one");
Iterator<String> iterator = mylist.iterator();
while( iterator.hasNext() ) {
  iterator.next();
  mylist.remove(0);  // throws the exception
}