MongoDatabase db = mongoClient.getDatabase("test");

MongoCollection<Document> collection = db.getCollection("sample");

String searchString = new String("Arya Stark");

List<Document> pipeline = Arrays.<Document>asList(
  new Document("$match",
    new Document("show.season.episodes.metaTags",searchString)
  ),
  new Document("$project",
    new Document("show",
      new Document("$setDifference",
        Arrays.<Object>asList(
          new Document("$map",
            new Document("input","$show")
              .append("as","show")
              .append("in",
                new Document("$let",
                  new Document("vars",
                    new Document("season",
                      new Document("$setDifference",
                        Arrays.<Object>asList(
                          new Document("$map",
                            new Document("input","$$show.season")
                              .append("as","season")
                              .append("in",
                                new Document("$let",
                                  new Document("vars",
                                    new Document("episodes",
                                      new Document("$setDifference",
                                        Arrays.<Object>asList(
                                          new Document("$map",
                                            new Document("input","$$season.episodes")
                                              .append("as","episode")
                                              .append("in",
                                                new Document("$cond",
                                                  Arrays.<Object>asList(
                                                    new Document("$setIsSubset",
                                                      Arrays.<Object>asList(
                                                        "$$episode.metaTags",
                                                        Arrays.<Object>asList(searchString)
                                                      )
                                                    ),
                                                    "$$episode",
                                                    false
                                                  )
                                                )
                                              )
                                          ),
                                          Arrays.<Object>asList(false)
                                        )
                                      )
                                    )
                                  )
                                    .append("in",
                                      new Document("$cond",
                                        Arrays.<Object>asList(
                                          new Document("$ne",
                                            Arrays.<Object>asList(
                                              "$$episodes",
                                              Arrays.<Object>asList()
                                            )
                                          ),
                                          new Document("_id","$$season._id")
                                            .append("episodes","$$episodes"),
                                          false
                                        )
                                      )
                                    )
                                )
                              )
                          ),
                          Arrays.<Object>asList(false)
                        )
                      )
                    )
                  )
                    .append("in",
                      new Document("$cond",
                        Arrays.<Object>asList(
                          new Document("$ne",
                            Arrays.<Object>asList(
                              "$$season",
                              Arrays.<Object>asList()
                            )
                          ),
                          new Document("name","$$show.name")
                            .append("season","$$season"),
                          false
                        )
                      )
                    )
                )
              )
          ),
          Arrays.<Object>asList(false)
        )
      )
    )
  )
);

System.out.println(JSON.serialize(pipeline));

AggregateIterable<Document> result = collection.aggregate(pipeline);

MongoCursor<Document> cursor = result.iterator();

while (cursor.hasNext()) {
  Document doc = cursor.next();
  System.out.println(doc.toJson());
}