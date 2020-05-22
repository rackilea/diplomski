int i = 0;
String s = "s";
Object o = new Object();
Foo foo = new Foo();

int r = i + i; // allowed
char c = 'c' + 'c'; // allowed
String s2 = s + s; // allowed
Object o2 = o + o; // NOT allowed
Foo foo = foo + foo; // NOT allowed
String s3 = s + o; // allowed, invokes o.toString() and uses StringBuilder
String s4 = s + o + foo; // allowed
String s5 = o + foo; // NOT allowed - there's no string operand