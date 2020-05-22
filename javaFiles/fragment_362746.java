MongoCollection<Document> collection = database.getCollection("lists");

Document updatedDocument = collection.findOneAndUpdate(
    Filters.eq("name", listName),
    new Document("$push",
        new BasicDBObject("terms", new BsonString(newVocabTerm))
            .append("definitions", new BsonString(newDefinition))),
        new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER));