protected RouteBuilder createRouteBuilder() throws Exception {
  return new RouteBuilder() {
    public void configure() throws Exception {
      restConfiguration()
      .component("spark-rest")
      .port(9091);