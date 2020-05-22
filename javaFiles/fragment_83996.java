BasicDBObject query = new BasicDBObject();
        BasicDBObject condition1 = new BasicDBObject("fieldA",new BasicDBObject("$gt","2018-06-02 12:20:00").append("$lt","2019-06-02 12:20:00"));
        BasicDBObject condition2 = new BasicDBObject("fieldB",new BasicDBObject("$gt","2018-06-02 12:20:00").append("$lt","2019-06-02 12:20:00"));

        BasicDBList condList = new BasicDBList();
        condList.add(condition1);
        condList.add(condition2);
        query.put("$or" ,condList);

        collection.find(query);