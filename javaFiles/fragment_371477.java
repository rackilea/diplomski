String x = new String("foo");
String y = new String("foo");
String z = "foo";

// Expressions and their values:
x == y: false
x == z: false
x.intern() == y.intern(): true
x.intern() == z: true