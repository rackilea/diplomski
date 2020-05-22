LinkedList<ArrayList<String>> partials = new LinkedList<ArrayList<String>>();
ArrayList<String> list = new ArrayList<String>();
list.add("Test");

// Create a shallow copy and add a reference to that into the linked list
partials.add(new ArrayList<String>(list));

list.add("Another element");

// Prints 1, because the lists are distinct
System.out.println(partials.element().size());