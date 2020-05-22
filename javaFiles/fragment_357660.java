public class AuditCriteriaRepositoryImpl implements AuditCriteriaRepository {

  private final MongoTemplate mongoTemplate;

  public AuditCriteriaRepository(MongoTemplate mongoTemplate){
    this.mongoTemplate = mongoTemplate;
  }


  public List<AuditEntity > getAuditEntitiesByStatus(AuditStatus auditStatus, Instant instant){
    Query query = new Query();
    query.addCriteria(Criteria.where("status")
        .is(auditStatus)
    ).addCriteria(Criteria.where("createdAt").lt(instant));
    return mongoTemplate.find(query, AuditEntity.class);
  }
}