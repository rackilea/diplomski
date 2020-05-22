Foo foo1 = new Foo();
Foo foo2 = foo1;
// The values of foo1 and foo2 are now the same: they are references to the same object
foo1.bar = new Bar();
System.out.println(foo2.bar); // Prints Message
foo2 = null;
System.out.println(foo2); // Prints null
System.out.println(foo1.bar); // Still prints Message