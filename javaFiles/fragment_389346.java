public Foo(Object... os){} 

public Bar(Object[] os) {}

Foo(new Object[]{new Object(), new Object()}); // compiles fine.

Bar(new Object(), new Object()); // Fails to compile.