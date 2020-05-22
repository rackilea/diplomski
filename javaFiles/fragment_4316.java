MongoClient mongoClient = new MongoClient("localhost", 27017);
DB db = mongoClient.getDB("test");
DBCollection coll = db.getCollection("testcol");

LocalDate ld = LocalDate.now();
Instant instant = ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
Date date = Date.from(instant);

BasicDBObject doc = new BasicDBObject("localdate", date);
coll.insert(doc);