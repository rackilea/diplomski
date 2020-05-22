public static class ThrowingAnswer implements Answer<Object> {
  @Override public Void answer(InvocationOnMock invocation) throws Throwable {
    if (invocation.getMethod().getReturnType() == Void.TYPE) {
      throw new UnsupportedOperationException(String.format(
          "Method %s not stubbed on %s",
          invocation.getMethod().getName(),
          invocation.getMock()));
    }
    return Answers.RETURNS_DEFAULTS.answer(invocation);
  }
}

YourClass mockYourClass = Mockito.mock(YourClass.class, new ThrowingAnswer());