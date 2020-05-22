public Foo(Object o, Object... os){} 

public Foo(Object[] os) {}

Foo(new Object(), new Object()); // calls the first.

Foo(new Object[]{new Object(), new Object()}); // calls the second.