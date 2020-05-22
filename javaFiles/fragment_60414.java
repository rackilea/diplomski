@Test
public void testGetMessage() {
  String expectedMessagePrefix = "Button was clicked at ";
  String message = testedClass.getMessage();
  assertTrue("did not get the expected message", message.startsWith(expectedMessagePrefix));
}