Update update = new Update.Builder(payload)
  .index(aliasName)
  .type(typeName)
  .id(docId)
  .setParameter("retry_on_conflict", 5)
  .build();