List<Number> revisions = reader.getRevisions( MyEntity.class, myEntityId );
for ( Number revisionNumber : revisions ) {
  for ( String propertyName : propertyNamesToCheckList ) {
    final Long hits = reader.createQuery()
      .forRevisionsOfEntity( MyEntity.class, false, false  )
      .add( AuditEntity.id().eq( myEntityId ) )
      .add( AuditEntity.revisionNumber().eq( revisionNumber ) )
      .add( AuditEntity.propertyName( propertyName ).hasChanged() )
      .addProjection( AuditEntity.id().count() )
      .getSingleResult();

    if ( hits == 1 ) {
      // propertyName changed at revisionNumber
    }
    else {
      // propertyName didn't change at revisionNumber
    }
  }
}