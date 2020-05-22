MongoClient mongo = new MongoClient();
    DB db = mongo.getDB("your_database");
    BasicDBObject emailId = new BasicDBObject("$ifNull",Arrays.asList("$email_id", " "));
    BasicDBObject phoneNum = new BasicDBObject("$ifNull", Arrays.asList("$phone_num", "NA"));
    DBObject project = new BasicDBObject("$project" , new BasicDBObject("email_id", emailId).append("phone_num", phoneNum).append("id" , 1).append("firstname" , 1).append("lastname", 1).append("status", 1));
    DBObject match = new BasicDBObject("$match", new BasicDBObject("status", "true")); 
    DBObject concat = new BasicDBObject("$concat", Arrays.asList( "$firstname", " ", "$lastname", " | ", "$email_id" , " | ", "$phone_num"));
    Document concatDoc = new Document("$concat", Arrays.asList( "$firstname", " ", "$lastname", " | ", "$email_id" , " | ", "$phone_num"));
    DBObject group = new BasicDBObject("$group", new BasicDBObject("_id", "$id").append("details", new BasicDBObject("$push", concat)));

    AggregationOutput iterable = db.getCollection("your_collection").aggregate(project, match, group);