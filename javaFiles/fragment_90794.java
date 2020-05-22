MongoClient mongoConnection = new MongoClient("localhost", 27017);

try {
    MongoDatabase db = mongoConnection.getDatabase("db");
    MongoCollection<Document> collection = db.getCollection("orders");
    BasicDBObject whereQuery = new BasicDBObject();
    whereQuery.put("user_id", "1");
    whereQuery.put("is_placed", false);
    whereQuery.put("items.product_id", 1);
    BasicDBObject incValue = new BasicDBObject("items.$.units", 1);
    BasicDBObject intModifier = new BasicDBObject("$inc", incValue);
    collection.updateOne(whereQuery, intModifier);
} catch (Exception e) {
    e.printStackTrace();
}