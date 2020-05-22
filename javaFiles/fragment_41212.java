IFoo myFoo;
if (FOO_FLAG) { // possibly a public static final boolean
  myFoo = new com.x.y.z.Foo();
} else {
  myFoo = new com.a.b.c.Foo();
}