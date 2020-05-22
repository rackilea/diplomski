Document match = new Document("$match", new Document("employee_id", new ObjectId("5d4dc8635dd32dbcba4ae0af")));

// build the $lookup operations
Document lookupFields = new Document("from", "dept");
lookupFields.put("localField", "dept_id");
lookupFields.put("foreignField", "_id");
lookupFields.put("as", "dept");
Document lookup = new Document("$lookup", lookupFields);

// build unwind operation
Document unwind = new Document("$unwind", "$dept");

// build the $projection operations
Document projectFields = new Document("name", "$dept.name");
projectFields.put("_id", new Document("$toString", "$dept._id"));
Document project = new Document("$project", projectFields);

List<Document> pipeline = Arrays.asList(match, lookup, unwind, project);

AggregateIterable<Document> aggregateIterable = groupDAO.database.getCollection("employee_dept")
        .aggregate(pipeline);

for (Document result : aggregateIterable) {
    System.out.println(result.toJson());
}