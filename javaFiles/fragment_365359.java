public NewsEntity getNewsDetail(Long id) {
    return mongoOperations.findOne(
        Query.query(Criteria.where("_id").is(id)),
        NewsEntity.class,
        COLLECTION_NAME
    );
}