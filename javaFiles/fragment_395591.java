@Test
public void testMyMethod() {
  //test default
  String test = Foo.bar(null);
  assertEquals("foo", test);

  //test case 1
  Foo.bar(aValue);
  //Oops forgot to set value above, this passes regardless of 
  //what the above call does
  assertEquals("foo", test);
}