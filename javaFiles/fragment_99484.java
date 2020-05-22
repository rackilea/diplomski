List<String> batch = new ArrayList<>();
batch.add("INSERT INTO emp (NAME) VALUES ('JOE')");
batch.add("INSERT INTO emp (NAME) VALUES ('JANE')");

connection.batch(batch, res -> {
  if (res.succeeded()) {
    List<Integer> result = res.result();
  } else {
    // Failed!
  }
});