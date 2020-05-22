BasicDBList list = new BasicDBList();
list.add( new ObjectId("123") );
// Add the rest...

DBObject inStatement = new BasicDBObject( "$in", list );
column.updateMulti( new BasicDBObject( "_id", inStatement ), new BasicDBObject( "$set", new BasicDBObject( "field", 59 ) );