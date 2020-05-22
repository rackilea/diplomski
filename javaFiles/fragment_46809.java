restConfiguration().component("jetty")
  .host(this.host)
  .port(this.port)
  .contextPath(this.contextPath);

rest("myService/").post()
  .produces("application/json; charset=UTF-8")
  .to(SERVICE_CONTEXT_IN);

from(SERVICE_CONTEXT_IN).process(this.requestLogProcessor)
  .unmarshal()
  .json(JsonLibrary.Jackson, MyServiceRequest.class)
  .process(this.serviceProcessor)
  .marshal()
  .json(JsonLibrary.Jackson);