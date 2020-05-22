public static void main(String[] args) throws Exception {

    MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
    // Now connect to your databases
    DB db = mongoClient.getDB("demo");
    DBCollection collection = db.getCollection("counters");
    BasicDBObject document = new BasicDBObject();

    document.put("_id", getNextSequence("userid"));
    document.put("name","Sarah C.");
    collection.insert(document); // insert first doc

    document.put("_id", getNextSequence("userid"));
    document.put("name", "Bob D.");
    collection.insert(document); // insert second doc
}