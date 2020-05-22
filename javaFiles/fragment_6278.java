ArrayList<LinkedList<String>> array = new ArrayList<LinkedList<String>>(size);

// add a bunch of lists
// How many depends on how deep you want the chaining if you are doing    
// this for a hash function.

array.add(new LinkedList<String>());
array.add(new LinkedList<String>());
array.add(new LinkedList<String>());
array.add(new LinkedList<String>());
array.add(new LinkedList<String>());

// Now based on what index you need (e.g. your hash result), you insert into that list.
int index = hashFunction(...);  
array.get(index).add("abc");