@Test
public void testIterate() throws Exception {

    when(myClass.getValue()).thenReturn(10d,20d,30d,40d,50d);

    iteratorClass.iterate();
}