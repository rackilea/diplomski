BasicDBObject match = new BasicDBObject("$match", 
                new BasicDBObject("$text", new BasicDBObject("$search", "COST")));

List<DBObject> aggregationList = new ArrayList<DBObject>();
aggregationList.add(match);

AggregationOutput aggregationOutput = mongoTemplate.getCollection("categoryMaster")
        .aggregate(aggregationList);

List<DBObject> dbObjects = (List<DBObject>) aggregationOutput.results();