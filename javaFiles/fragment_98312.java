import org.bson.types.ObjectId;
...

MongoClient mongo = new MongoClient("localhost",27017);
DB db = mongo.getDB("sample");
DBCollection col = db.getCollection("matching");
BasicDBObject query = new BasicDBObject();
query.put("_id", new ObjectId("56cec592fe3fc16f6b564761"));
DBObject dbObj = col.findOne(query);