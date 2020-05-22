when(q.executeUpdate()).thenAnswer( new Answer<Foo>() {
    @Override
    public Foo answer(InvocationOnMock invocation) throws Throwable {
      callYourOtherMethodHere();
      return something;
    }
} );