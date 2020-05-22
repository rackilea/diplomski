DBObject idMatch = new BasicDBObject("user_id","bc");
    DBObject usernameMatch = new BasicDBObject("user_name",bc);
    DBObject ageMatch = new BasicDBObject("age",2);

    DBObject andAll = new BasicDBObject("$and", Arrays.asList(existence, firstNotMatch, secondNotMatch));

    //calling  table.find will get you what you wanted.
    table.find(andAll);