MongoClient mongoClient = new MongoClient();
DB db = mongoClient.getDB( DBNAME );

DBCollection collection = db.getCollection( "FILE_JOURNEY" );

DBObject subscriberId = new BasicDBObject( "SUBSCRIBERID", "225136298" );
DBObject subscriberIdIsNull = new BasicDBObject( "SUBSCRIBERID", null );
BasicDBList firstOrValues = new BasicDBList();
firstOrValues.add( subscriberId );
firstOrValues.add( subscriberIdIsNull );
DBObject firstOr = new BasicDBObject( "$or", firstOrValues );

DBObject batchId = new BasicDBObject( "BATCHID", "615060299" );
DBObject fileName = new BasicDBObject( "FILENAME", "TR.NYHBE.834Q.D.212311980342.QHP.dat" );
BasicDBList secondOrValues = new BasicDBList();
secondOrValues.add( batchId );
secondOrValues.add( fileName );
DBObject secondOr = new BasicDBObject( "$or", secondOrValues );
BasicDBList andValues = new BasicDBList();
andValues.add( firstOr );
andValues.add( secondOr );

DBObject query = new BasicDBObject( "$and", andValues );

DBCursor cursor = collection.find( query );