...

DBObject obj = new BasicDBObject();
obj.put( "key", 1 );
obj.put( "value", "one" );
DBObject obje1 = new BasicDBObject();
obje1.put( "$elemMatch", obj );

obj = new BasicDBObject();
obj.put( "key", 2 );
obj.put( "value", "two" );
DBObject obje2 = new BasicDBObject();
obje2.put( "$elemMatch", obj );

Query qry = new Query( where("array").all(obje1, obje2) );

...