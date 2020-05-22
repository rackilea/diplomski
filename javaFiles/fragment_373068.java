MongoCollection<Document> table = ...;

// {"shapes.color": "red"}
BasicDBObject query = new BasicDBObject("shapes.color", "red");

// {_id: 0, 'shapes.$': 1}
BasicDBObject projection = new BasicDBObject("shapes.$", "1").append("_id", 0);

FindIterable<Document> documents = table
    // assign the query
    .find(query)
    // assign the projection
    .projection(projection);

System.out.println(documents.first().toJson());