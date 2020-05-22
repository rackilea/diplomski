BasicDBObject query = new BasicDBObject("name", "chabeee");
BasicDBObject keys = new BasicDBObject();
keys.put("_id", 0);
keys.put("name", 1);
keys.put("worksAt", 1);
BasicDBCursor result = collection.find(query, keys);