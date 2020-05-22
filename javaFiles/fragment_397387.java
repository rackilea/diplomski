@Test
public void testPerformAnything() throws Exception {
   AnythingPerformerClass mockedPerformer = Mockito.mock(AnythingPerformerClass.class);
   MyClass clazz = new MyClass(mockedPerformer);
   ...
}