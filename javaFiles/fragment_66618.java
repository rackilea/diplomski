DBCollection collection = db.getCollection("collection");
BasicDBObject document = new BasicDBObject();
DBCursor cursor = collection.find();
while (cursor.hasNext()) {
    DBObject cur = cursor.next();
    String id = cur.get("_id").toString();
    String c = cur.get("count").toString();
    int updateCount = Integer.parseInt(c);  //change to int
    BasicDBObject updateQuery = new BasicDBObject();
    updateQuery.append("$set", new BasicDBObject().append("count", updateCount));
    BasicDBObject searchQuery = new BasicDBObject();
    searchQuery.put("_id", new ObjectId(id));
    collection.update(searchQuery, updateQuery);
}