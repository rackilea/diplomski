List <DBObject> aggregationInput = new ArrayList <DBObject> ();

BasicDBObject match = new BasicDBObject();
BasicDBObject matchQuery = new BasicDBObject();
matchQuery.put("_id", new ObjectId());
match.put("$match", matchQuery);
aggregationInput.add(match);

BasicDBObject unwind = new BasicDBObject();
unwind.put("$unwind", "$requests");
aggregationInput.add(unwind);

BasicDBObject groupVal = new BasicDBObject();
groupVal.put("_id", "$_id");
groupVal.put("count", new BasicDBObject().put("$sum", 1));

BasicDBObject group = new BasicDBObject();
group.put("$group", groupVal);
aggregationInput.add(group);

AggregationOutput output = followRequestsCol.aggregate(aggregationInput);
for (DBObject result : output.results()) {
    System.out.println(result);
}