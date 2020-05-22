Mongo m = new Mongo();
DB db = m.getDB( "test" );

DBCollection coll = db.getCollection("test");       
coll.insert(new BasicDBObject("Name","Wes").append("x", "to have a second field"));
BasicDBObject query = new BasicDBObject(); 
BasicDBObject fields = new BasicDBObject("Name",1).append("_id",false);
DBCursor curs = coll.find(query, fields);

while(curs.hasNext()) {
  DBObject o = curs.next();
  System.out.println(o.toString());
}