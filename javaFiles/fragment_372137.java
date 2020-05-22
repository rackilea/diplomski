WeakHashMap testMapHashWeak = new WeakHashMap<Object, String>();

String value1 = "Hola1!";
String value2 = "Hola2!";

String key1 = new String("key");
String key2 = new String("key");

assert key1 != key2; // Keys are different objects...
assert key1.equals(key2); // but are equal to each other

testMapHashWeak.put(key1, value1);
testMapHashWeak.put(key2, value2);

// value2 instead of value1!
System.out.println("Get using key1 (expected Hola1): "+testMapHashWeak.get(key1));
// value2
System.out.println("Get using key2 (expected Hola2): "+testMapHashWeak.get(key2));

Object key3 = new Object();
Object key4 = new Object();

assert key3 != key4; // Keys are different objects...
assert !key3.equals(key4); // and are not equal to each other

testMapHashWeak.put(key3, value1);
testMapHashWeak.put(key4, value2);

// value2 instead of value1!
System.out.println("Get using key3 (expected Hola1):"+testMapHashWeak.get(key3)); // value1!
// value2
System.out.println("Get using key4 (expected Hola2):"+testMapHashWeak.get(key4));