public void processElement(ProcessContext c) {
    final Datastore datastore = DatastoreOptions.defaultInstance().service();
    final KeyFactory keyFactory = datastore.newKeyFactory().kind("Task");

    Key key = datastore.allocateId(keyFactory.newKey());
    Entity task = Entity.builder(key)
        .set("description", StringValue.builder(":D").excludeFromIndexes(true).build())
        .set("created", DateTime.now())
        .set("done", false)
        .build();
    datastore.put(task);
}