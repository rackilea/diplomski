@Test
public void myTest() {
      replace(method(Foo.class, "getInstance"))
         .with(method(MyTest.class, "getMockInstance"));

      Foo foo = Foo.getInstance();  // works well
      Baz baz1 = new Baz();
      Baz baz2 = new Baz();
      EasyMock.expect(foo.bar(baz1)).andReturn(baz2);  // exception thrown
      EasyMock.replay(foo);
}

  public static Foo getMockInstance() {
      Foo foo = EasyMock.createMock(Foo.class);
      return foo;
   }