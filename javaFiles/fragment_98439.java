// Input is Collection<DBObject> as variable in

    // New way to get the collection
    MongoClient client = new MongoClient();
    MongoCollection<Document> collection = client.getDatabase("mydb").getCollection("myColl");

    // Prepare list of update URLs
    List<String> urls = in.stream().map(dbObject -> (String) dbObject.get("url")).collect(Collectors.toList());

    // Update many with $in and the same update operation
    collection.updateMany(Filters.in("url", urls), Updates.inc("count", 1));