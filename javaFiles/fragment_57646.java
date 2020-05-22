MongoCollection<Document> collection = mongoTemplate.getDb().getCollection("col");

 Bson update = Updates.set("menuProductCategories.$[].menuProducts.$[i].refProduct.name", "TEST");
 Bson filter = Filters.eq("i.refProduct.id", new ObjectId(refProduct.getId()));
 UpdateOptions updateOptions = new UpdateOptions().arrayFilters(Arrays.asList(filter));

 collection.updateOne(null, update, updateOptions);