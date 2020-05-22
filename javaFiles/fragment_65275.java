ArrayList<ArrayList<String>> parentlist = new ArrayList<ArrayList<String>>();

// get the childlist on position 2
ArrayList<String> childlist = parentlist.get(2);

// if childlist is not null the list already exist and you can add your strings
// otherwise you have to create a new list and add it to your parent list
if(childlist != null) {
  childlist.add("a");
  childlist.add("b");
  childlist.add("c");
}
else {
  childlist = new ArrayList<String>();
  childlist.add("a");
  childlist.add("b");
  childlist.add("c");

  // add the new childlist to the parent list because it didn't exist
  parentlist.add(childlist);
}