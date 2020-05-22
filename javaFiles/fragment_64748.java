uri = new MongoClientURI("mongodb://<MongoURI>");
mongoClient = new MongoClient(uri);

//http://api.mongodb.org/java/3.0/com/mongodb/DB.html
// create a object of the DB class
mongoDB = mongoClient.getDB(uri.getDatabase());

//http://api.mongodb.org/java/3.0/com/mongodb/DB.html#getCollection-java.lang.String-
playerCollection =  mongoDB.getCollection("players");

// now that you have a DBCollection object you can use the distinct(String) method
searchResults = playerCollection.distinct("team");