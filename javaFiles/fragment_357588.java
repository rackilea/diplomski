@Test
public void testSomething() throws Exception {
    List listMock = mock(List.class);
    Method m = List.class.getDeclaredMethod("get", int.class);
    m.invoke(listMock, Mockito.anyInt());

    when(null).thenReturn("Hello World");  // Huh? passing null?

    assertEquals("Hello World", listMock.get(0)); // works!
}