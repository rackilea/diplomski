@Test
public void testPullAndFlushData() {
     URI uri = ...;
     Params params = ...;
     ByteArrayOutputStream spybaos = spy(new ByteArrayOutputStream());
     someObject.pullAndFlushData(spybaos, uri, params);
     assertSomething(..., spybaos.toByteArray());
     verify(spybaos).flush(); // asserts that flush() has been called.
}