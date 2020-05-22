Bson filter = and(eq("field1", "value"), gt("field2", "value2"));
BsonDocument bsonDocument = filter.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry());

Bson optionalFilter = eq("field3", "optionalValue");
BsonDocument optionalBsonDocument = optionalFilter.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry());

// now add the optional filter to the BsonDocument representation of the original filter
bsonDocument.append("field3", optionalBsonDocument.get("field3"));

Bson completeFilter = and(eq("field1", "value"), gt("field2", "value2"), eq("field3", "optionalValue"));
BsonDocument completeBsonDocument = completeFilter.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry());

assertThat(completeBsonDocument, is(bsonDocument));