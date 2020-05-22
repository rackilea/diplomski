MongoClient mc = new MongoClient();
MongoDatabase db = mc.getDatabase("db");
MongoCollection col = db.getCollection("col");

Bson query = Filters.and(Filters.eq("timestamp_hour", timestampHour), Filters.eq("userid", userId));
Document uDoc = new Document();
uDoc.put("input", xxx);
uDoc.put("output", yyy);

Bson update = Updates.set("balances." + number, uDoc);

col.updateOne(query, update);