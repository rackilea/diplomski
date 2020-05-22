coll.insert(new BasicDBObject("Name","Wes").append("x", "to have a second field"));
coll.insert(new BasicDBObject("Name","Alex").append("x", "to have a second field"));
coll.insert(new BasicDBObject("Name","Zeus").append("x", "to have a second field"));
BasicDBObject query = new BasicDBObject(); 
BasicDBObject fields = new BasicDBObject("Name",1).append("_id",false);
BasicDBObject orderBy = new BasicDBObject("Name",1);
DBCursor curs = coll.find(query, fields).sort(orderBy);
while(curs.hasNext()) {
   DBObject o = curs.next();
   System.out.println(o.toString());
}