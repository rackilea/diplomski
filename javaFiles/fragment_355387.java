final Map<A, String> map = new HashMap<A, Object>();
final A first = new A("fe", "fi", "fo", "fum");

map.put(first, "success");

// later on
final A second = new A ("fe", "fi", "foo", "bar");
System.out.println(map.get(second)); // prints "success";