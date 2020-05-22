@Test
public void test() {
    // Tell the top class
    RuntimeTypeAdapterFactory<Request> rttaf = RuntimeTypeAdapterFactory.of(Request.class)
        // Register inheriting types and the values per type field
        .registerSubtype(ForwardRequest.class, "Forward")
        .registerSubtype(LoginRequest.class, "Login");
    Gson gson = new GsonBuilder().setPrettyPrinting()
        .registerTypeAdapterFactory(rttaf)
        .create();
    // Constructed an array of your two types to be deserialized at the same time  
    String jsonArr = "["
          + "{\"type\": \"Login\", \"content\": {\"username\": \"a\", \"password\": \"b\"}}"
          + ","
          + "{\"type\": \"Forward\", \"content\": {\"deviceId\": \"a\", \"password\": \"b\"}}"
          + "]";
    // Deserialize the array as Request[]
    Request[] requests = gson.fromJson(jsonArr, Request[].class);
    log.info("{}", requests[0].getClass());
    log.info("{}", requests[1].getClass());   
}