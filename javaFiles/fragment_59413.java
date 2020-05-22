Map<String, Serializable> myMap = new HashMap<String, Serializable>();
Bar bar = new Bar();
map.put("BAR", bar); // this is ok
Foo foo = new Foo();
map.put("FOO", foo); 
// The method put(String, Serializable) in the type HashMap<String,Serializable> 
// is not applicable for the arguments (String, Foo)