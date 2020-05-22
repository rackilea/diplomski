Entity getEntity(GUID entityId) {
  Entity entity = entityLRUCache.get(entityId);
  if (entity == null) {
    entity = longLoadFromDatabase(entityId);
    entityLRUCache.put(entityId, entity);
  }
  return entity;
}