MongoClient mongo = new MongoClient();    
MongoDatabase database = mongo.getDatabase("your_database");
        Document emailIdDoc = new Document("$ifNull",Arrays.asList("$email_id", " "));
        Document phoneNumDoc = new Document("$ifNull", Arrays.asList("$phone_num", "NA")); 
        Document projectDoc = new Document("$project" , new Document("email_id", emailIdDoc).append("phone_num", phoneNumDoc).append("id" , 1).append("firstname" , 1).append("lastname", 1).append("status", 1));
        Document matchDoc = new Document("$match", new BasicDBObject("status", "true"));
        Document groupDoc = new Document("$group", new Document("_id", "$id").append("details", new Document("$push", concat)));
        AggregateIterable<Document> aggregationResult = db.getCollection("your_collection").aggregate(asList(projectDoc, matchDoc, groupDoc));