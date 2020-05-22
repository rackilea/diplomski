BasicDBObject match = new BasicDBObject("sid",11);
    BasicDBObject firstmatchObj = new BasicDBObject();
    firstmatchObj.put("$match", match);
    BasicDBObject unwind = new BasicDBObject("$unwind","$shapes");
    BasicDBObject matchAfterUnwind = new BasicDBObject("shapes.shape",new BasicDBObject("$regex",".r."));
    BasicDBObject secondmatchObj = new BasicDBObject();
    secondmatchObj.put("$match", matchAfterUnwind);
    List<DBObject> pipeline = new ArrayList<>();
    pipeline.add(firstmatchObj);
    pipeline.add(unwind);
    pipeline.add(secondmatchObj);
    AggregationOutput output = collection.aggregate(pipeline);
    for (DBObject res : output.results()) {
        System.out.println(res);
    }