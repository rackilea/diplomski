MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
MongoDatabase db = mongoClient.getDatabase("test");
System.out.println("Connect to database successfully");

boolean auth = db.authenticate(myUserName, myPassword);
System.out.println("Authentication: "+auth);
MongoCollection<Document> coll = database.getCollection("mycol");
System.out.println("Collection mycol selected successfully");

Document doc = new Document("title", "MongoDB").
            append("description", "database").
            append("likes", 100).
            append("url", "http://www.instagram.com/").
            append("by", "users").
            append("instagram", new Document("description","database").append("likes", "likes"));


coll.insertOne(doc);