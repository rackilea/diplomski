client
  .get(8080, "myserver.mycompany.com", "/some-uri")
  .send(ar -> {
    if (ar.succeeded()) {
      Buffer body = ar.result().body();
      List<User> users = Json.decodeValue(body, new TypeReference<List<User>>() {});
    } else {
      // ...
    }
  });