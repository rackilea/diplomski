@Test
public void testExpectedException()
{
  MockedObject mockObj = mock(MockedObj.class);
  MySubject subject = new MySubject(mockedObj);
  try {
    subject.someMethodThrowingException();
    fail("Expected MyException.");
  } catch (MyException expected) {
    assertEquals("My exception message.", expected.getMessage());
  }
  verify(mockObj).someCleanup(eq(...));
}