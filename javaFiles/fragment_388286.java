A a1 = new A();
A a2 = new A();
A a3 = new A();

a2.relative = a1;
a3.relative = a1;
// Now both a2 relative and a3 relative point to the same A object.