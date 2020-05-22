List results = reader.forRevisionsOfEntityWithChanges( MyEntity.class false )
   .add( AuditEntity.id().eq( entityId ) )
   .getResultList();

Object previousEntity = null;
for ( Object row : results ) {
  Object[] rowArray = (Object[]) row;
  final MyEntity entity = rowArray[0];
  final RevisionType revisionType = (RevisionType) rowArray[2];
  final Set<String> propertiesChanged = (Set<String>) rowArray[3];
  for ( String propertyName : propertiesChanged ) {
    // using the property name here you know
    // 1. that the property changed in this revision (no compare needed)
    // 2. Can get old/new values easily from previousEntity and entity
  }
}