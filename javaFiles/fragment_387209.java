List<Integer> ids = Arrays.asList(1, 2, 3, 4);
MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "testDB");
Query q = new Query(where("_id").in(ids));
List<Test> deletedDocs = mongoOps.findAllAndRemove(q, Test.class, "testColl");
// -or-
//List<Document> deletedDocs = mongoOps.findAllAndRemove(q, "testColl");
System.out.println(deletedDocs);