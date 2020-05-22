try {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    Key sessionKey = KeyFactory.createKey("_ah_SESSION", "_ahs" + sessionId);
    Entity sessionEntity = datastore.get(sessionKey);
    Blob blob = (Blob) sessionEntity.getProperty(_VALUES);
    byte[] sessionBytes = blob.getBytes();

    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(sessionBytes);
    ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
    return (Map<String, Object>) objectInputStream.readObject();
} catch (EntityNotFoundException e) {   
    logger.log(Level.INFO, e.getMessage());
} catch (Exception e) {
    logger.log(Level.SEVERE, e.getMessage(), e);
}