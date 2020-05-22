BasicDBObject query = new BasicDBObject();
query.put("_id",email);
query.append("Password",pwd);
BasicDBObject obj = new BasicDBObject();
obj.put("_id",2);
DBCursor cursor = collection.find(query,obj);
return cursor.hasNext();