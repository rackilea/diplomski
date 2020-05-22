@Test
public void testPullAndFlushData() {
     URI uri = ...;
     Params params = ...;
     ByteArrayOutputStream baos = new ByteArrayOutputStream();
     someObject.pullAndFlushData(baos, uri, params);
     assertSomething(..., baos.toByteArray());
}