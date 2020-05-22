@Test
public void testIterate() throws Exception {

    when(myClass.getValue()).thenReturn(10d)
              .thenReturn(20d)
              .thenReturn(30d)
              .thenReturn(40d)
              .thenReturn(50d);

    iteratorClass.iterate();
}