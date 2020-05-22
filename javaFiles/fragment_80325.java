for ( Map.Entry<YourEntityIdType,Number> entry : idRevisionPairs.entrySet() ) {
  AuditQuery query = auditReader.createQuery()
    .forEntitiesAtRevision( Client.class, entry.getValue() )
    .add( AuditEntity.id().eq( entry.getKey() )
    .addProjection( ... );

  // here take the results from query and the id-timestamp pairs and
  // marry them into some DTO you return.
}