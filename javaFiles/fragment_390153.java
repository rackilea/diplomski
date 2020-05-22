BasicDBObject g1 = new BasicDBObject();
g1.put("users.$.full_name", "ram");
g1.put("users.$.user_name", "ram123");
g1.put("users.$.password", "pass$123");
g1.put("users.$.status", "Inactive");

BasicDBObject doc = new BasicDBObject();
doc.put("$set", g1);

BasicDBObject q = new BasicDBObject("users.user_name","asd");
con.update(q,doc);