@Test
public void testConfigure() {
  SomeImpl resourceInfo = ... ; // create a new instance of SomeImpl, or mock it if needed

  // prepare your mock
  FeatureContext context = Mockito.mock(FeatureContext.class);
  Mockito.doNothing().when(context).register(Mockito.any(ExampleFilter.class));

  // invoke the method under test
  JerseyBinding binding = new JerseyBinding();
  binding.configure(resourceInfo, context);

  // verify that we called register
  Mockito.verify(context).register(Mockito.any(ExampleFilter.class));

  // verify nothing else was called on the context
  Mockito.verifyNoMoreInteractions(context);
}