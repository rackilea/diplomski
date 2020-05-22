Query.Builder query = Query.newBuilder();
query.addKindBuilder().setName("__kind__");
query.addProjectionBuilder().setProperty(makePropertyReference("__key__"));

RunQueryRequest.Builder req = RunQueryRequest.newBuilder()
    .setQuery(query);
req.getPartitionIdBuilder().setNamespace("my_namespace");

datastore.runQuery(req.build());