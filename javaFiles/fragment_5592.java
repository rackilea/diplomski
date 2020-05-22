BasicDBObject orQuery = new BasicDBObject();

List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
obj.add(new BasicDBObject("x2", "y2"));
obj.add(new BasicDBObject("x3", "y3"));
andQuery.put("$and", obj);

List<BasicDBObject> obj2 = new ArrayList<BasicDBObject>();
obj2.add(new BasicDBObject("x1", "y1"));
obj2.add(andQuery);
orQuery.put("$or", obj2);