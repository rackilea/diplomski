String [] cats = new String[] {"childrens", "signed"};

List<DBObject> theMegaArray = new ArrayList<>();

BasicDBObject theProjections = new BasicDBObject();

for (int i = 1; i <= 5; i++) {
  String identifier = "categories.category" + i;
  String cleanIdentifier = "$" + identifier;
  //If the category does not exist, put in a blank category
  Object[] temp = new Object[] {cleanIdentifier, new Object[]{}};
  theMegaArray.add(new BasicDBObject("$ifNull", temp));
}

theProjections.put("_id", 1);
theProjections.put("pid", 1);
theProjections.put("categories",1);
theProjections.put("allCategories", new BasicDBObject("$setUnion", theMegaArray));

BasicDBObject theFilter = new BasicDBObject("allCategories", new BasicDBObject("$all", cats));

List<BasicDBObject> pipeline = new ArrayList<>();
pipeline.add(new BasicDBObject("$project", theProjections));
pipeline.add(new BasicDBObject("$match", theFilter));

AggregateIterable iterable = collection.aggregate(pipeline);