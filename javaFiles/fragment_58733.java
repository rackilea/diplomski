MyKey key1_1 = new MyKey("key1");

myMap.put(key1_1,someValue); // OK

someValue = myMap.get(key1_1); // returns the correct value, since the same key instance has been used;

MyKey key1_2  = new MaKey("key1"); // different key instance

someValue = myMap.get(key1_2); // returns null, because key1_2 has a different hashCode than key1_1 and key1_1.equals(key1_2) == false