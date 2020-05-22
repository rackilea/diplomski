UpdateOperations<Entity> update = mongoDataStore
    .createUpdateOperations(Entity.class)
    .disableValidation()
    .set("embedded.$.bar", new Date());

mongoDataStore.update(query, update);