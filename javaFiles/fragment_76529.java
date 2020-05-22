//try catch omitted
  Mongo mongo = new Mongo("localhost", 27017);
  DB db = mongo.getDB("db");

  BasicDBObject query = new BasicDBObject("item.name","item1");
  DBCursor cur = db.getCollection("items").find(query);
  while(cur.hasNext()) {
      BasicDBObject object = (BasicDBObject) cur.next();
      BasicDBObject item =  (BasicDBObject) object.get("item");
      BasicDBList valueslist = (BasicDBList) item.get("values");
      BasicDBObject values = (BasicDBObject) valueslist.get(0);
      BasicDBList value1 = (BasicDBList) values.get("value1");
      System.out.println(value1); 
  }