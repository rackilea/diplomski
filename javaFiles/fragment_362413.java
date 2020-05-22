// 1. "xyz" in the literal pool
// 2. a new String object which is a different object than "xyz" in the pool
String x = new String("xyz");

// 3. "abc" in the literal pool
String y = "abc";

// 4. new String object
x = x + y;