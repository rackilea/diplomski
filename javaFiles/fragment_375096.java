public static Object getNextSequence(String name) throws Exception{
    MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
    // Now connect to your databases
    DB db = mongoClient.getDB("demo");
    DBCollection collection = db.getCollection("counters");
    BasicDBObject find = new BasicDBObject();
    find.put("_id", name);
    BasicDBObject update = new BasicDBObject();
    update.put("$inc", new BasicDBObject("seq", 1));
    DBObject obj =  collection.findAndModify(find, update);
    return obj.get("seq");