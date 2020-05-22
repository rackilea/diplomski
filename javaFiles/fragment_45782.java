DBCollection coll = ...

DBObject query = new BasicDBObject("id", "5101");

DBObject pushObj = new BasicDBObject("dueId", new BasicDBObject("id", "003"));

DBObject setObj = new BasicDBObject();
setObj.put("overdueAmount", "200");
setObj.put("amount", "100");
setObj.put("customerContact", "Bim");

DBObject updateObj = new BasicDBObject();
updateObj.put("$push", pushObj);
updateObj.put("$set", setObj);

coll.update(query, updateObj);