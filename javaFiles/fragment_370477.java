public List<Alert> findAll() {
    Query query = new Query(where("id").exists(true));
    if (mongoTemplate == null) {
        throw new IllegalStateException("mongoTemplate is null");
    }
    return mongoTemplate.find(query, Alert.class);
}