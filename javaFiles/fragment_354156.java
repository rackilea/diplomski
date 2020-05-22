@Test
public void testFailuresOfClass() {
 Foo foo = new Foo();

 try {
    foo.doStuff();
    fail("doStuff() should not have succeeded");
 } catch (IndexOutOfBoundsException expected) {
    // This is what we want.
 }
 try {
    foo.doStuff(null);
    fail("doStuff(null) should not have succeeded");
 } catch (NullPointerException expected) {
    // This is what we want.
 }
 // etc for other failure modes
}