entityStore.executeInTransaction(txn -> {
    // ...
    if (!txn.find("EntityType", "propertyName", propValue).isEmpty()) {
        throw new ExodusException("Unique property violation");
    }
    entity.setProperty("propertyName", propValue);
    // ...
});