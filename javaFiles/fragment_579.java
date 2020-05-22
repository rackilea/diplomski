@Test
  public void testRoute() throws Exception {
    final String uri = "direct:start";
    Map headers;
    headers.put(Exchange.FILE_NAME, "myfile.txt");
    producer.sendBodyAndHeaders(uri, InOut, null, headers);
  }