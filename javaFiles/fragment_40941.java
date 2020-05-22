public class ThrowingAnswer extends Answer<Object> {
  @Override public Object answer(InvocationOnMock invocation) {
    throw new AssertionError("Unexpected invocation: " + invocation);
  }
}

// apply to the entire object:
YourObject yourObject = Mockito.mock(YourObject.class, new ThrowingAnswer());

// or per-method:
YourObject yourObject = Mockito.mock(YourObject.class);
doAnswer(new ThrowingAnswer()).when(yourObject).scaryMethod(any());