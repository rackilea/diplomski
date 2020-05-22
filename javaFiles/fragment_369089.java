// $group operation
 BasicDBList concat = new BasicDBList();
 concat.add("0");
 concat.add("$fields.innerTemp");
 DBObject groupFields = new BasicDBObject("_id", "$_id");
 groupFields.put("maxInnerTemp", new BasicDBObject("$max", new BasicDBObject("$concat", concat)); 
 DBObject group = new BasicDBObject("$group", groupFields);
     // run aggregation
     List < DBObject > pipeline = Arrays.asList(group); AggregationOutput output = collectionName.aggregate(pipeline);
     for (DBObject result: output.results()) {
       System.out.println(result);
     }