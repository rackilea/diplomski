BasicDBObject eleMatch = new BasicDBObject();
eleMatch.put("cityName","A");
BasicDBObject up = new BasicDBObject();
up.put("$elemMatch",eleMatch);
retrievedField.append(up);

BasicDBObject query = new BasicDBObject();
query.put("name","abc");

DBCollection dbcoll = mongoTemplate.getCollection("sample");
DBObject object = dbcoll.findOne(query, retrievedField);