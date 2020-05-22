AuditReader reader = AuditReaderFactory.get(entityManager);
AuditQuery query = reader.createQuery().forRevisionsOfEntity(cls, true, true);
if (fromDate!= null) {
    query.add(AuditEntity.revisionProperty("date").ge(fromDate))
}
// Etc
List<Object[]> changes = query.getResultList();