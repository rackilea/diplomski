List<JsonArray> batch = new ArrayList<>();
batch.add(new JsonArray().add("joe"));
batch.add(new JsonArray().add("jane"));

connection.batchWithParams("INSERT INTO emp (name) VALUES (?)", batch, res -> {
  if (res.succeeded()) {
    List<Integer> result = res.result();
  } else {
    // Failed!
  }
});