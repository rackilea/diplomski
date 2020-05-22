Multimap<String, String> myMultimap = ArrayListMultimap.create();

// Adding some key/value
myMultimap.put("Fruits", "Bannana");
myMultimap.put("Fruits", "Apple");
myMultimap.put("Fruits", "Pear");
myMultimap.put("Vegetables", "Carrot");

// Getting values
Collection<string> fruits = myMultimap.get("Fruits");
System.out.println(fruits); // [Bannana, Apple, Pear]