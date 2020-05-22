public List<SomeObject> findByNestedObjectId(String id) {
    Query query = Query.query(new Criteria("nestedObject._id", convertToObjectId(id)));
    return mongoTemplate.find(query, SomeObject.class);
}

Object convertToObjectId(Object id) {
    if (id instanceof String && ObjectId.isValid(id)) {
        return new ObjectId(id);
    }
    return id;
}