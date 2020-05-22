ClientConfig config = new DefaultClientConfig();
  Client client = Client.create(config);
  client.addFilter(new LoggingFilter());
  WebResource service = client.resource(getBaseURI());
  JSONObject inputJsonObj = new JSONObject();
  inputJsonObj.put("input", "Value");
  System.out.println(service.path("rest").path("hello").accept(MediaType.APPLICATION_JSON).post(JSONObject.class, inputJsonObj));