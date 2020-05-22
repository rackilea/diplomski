DBCollection myColl = db.getCollection("keyword_db"); 

    // for the $group operator
    DBObject groupFields = new BasicDBObject( "_id", "$names");
    groupFields.put("count", new BasicDBObject( "$sum", 1));

    DBObject group = new BasicDBObject("$group", groupFields );

    // for the $sort operator

    DBObject sortFields = new BasicDBObject("count", -1);

    DBObject sort = new BasicDBObject("$sort", sortFields );

    // run the aggregation

    AggregationOutput output = myColl.aggregate(group, sort);

    System.out.println( output.getCommandResult() );