MyObject o = new MyObject();
myMap.put("key", o);

o.setName("foo");
myMap.get("key").getName(); //will return "foo"
myMap.get("key").setName("bar");
myMap.get("key").getName(); //will return "bar"

o = null; //this applies only for your local reference, not for the map
myMap.get("key").getName(); //will STILL return "bar"