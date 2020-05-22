Iterable<DBObject> output = collection.aggregate(Arrays.asList(
        (DBObject) new BasicDBObject("$unwind", "$views"),
        (DBObject) new BasicDBObject("$match", new BasicDBObject("views.isActive", true)),
        (DBObject) new BasicDBObject("$sort", new BasicDBObject("views.date", 1)),
        (DBObject) new BasicDBObject("$limit", 200),
        (DBObject) new BasicDBObject("$project", new BasicDBObject("_id", 0)
                    .append("url", "$views.url")
                    .append("date", "$views.date"))
        )).results();

// Print for demo
for (DBObject dbObject : output)
{
    System.out.println(dbObject);
}