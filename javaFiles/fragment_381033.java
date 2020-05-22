// unwind 192_168_10_17
DBObject unwind = new BasicDBObject("$unwind", "$192_168_10_17");
// create  pipeline operations, with the $match
DBObject match = new BasicDBObject("$match",new BasicDBObject("192_168_10_17.type", "User.Notice"));
// Now the $group operation
 DBObject groupFields = new BasicDBObject("_id", "$192_168_10_17.type");
groupFields.put("count", new BasicDBObject("$sum", 1));
DBObject group = new BasicDBObject("$group", groupFields);
// build the $projection operation
DBObject fields = new BasicDBObject("_id", 0);
fields.put("count", "$count");
DBObject project = new BasicDBObject("$project", fields);
// run aggregation
List < DBObject > pipeline = Arrays.asList(match, group, project);
 AggregationOutput output = collectionName.aggregate(pipeline);
for (DBObject result: output.results()) {
 System.out.println(result);
}