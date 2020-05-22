model = Mockito.mock(Model.class);
final Map<Foo, List<Bar>> value = new HashMap<Foo, List<Bar>>();

Mockito.when(model.getValue()).thenAnswer(new Answer<Map<Foo, List<Bar>>> () {
  public Map<Foo, List<Bar>> answer(InvocationOnMock invocation) throws Throwable {
    return value;
  }
});