// Populate a map, with an A as the key
final Map<A, String> map = new HashMap<A, Object>();
final A a = new A("one", "two", "three", "four");
map.put(a, "here");

// Mutate a
a.setField1("un");

// Now look up what we associated with it
System.out.println(map.get(a)); // prints "null" - huh?
System.out.println(map.containsKey(a)); // prints "false"