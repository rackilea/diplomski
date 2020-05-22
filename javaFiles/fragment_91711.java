MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017));
 MongoClient mongo = new MongoClient("localhost", 27017);
 DB mongodb = (DB) mongo.getDB("testDB");
 DBCollection collection = mongodb.getCollection("collection");

 BasicDBObject findObject = new BasicDBObject().append("i","99159");
 BasicDBObject sortObject = new BasicDBObject().append("_id", -1);

 DBCursor cur = collection.find(findObject).sort(sortObject).limit(1);
 DBObject obj = cur.one();