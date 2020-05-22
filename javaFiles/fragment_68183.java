private String objectId;
private transient SomeObject localObject;
SomeObject getLocalObject() {
    if (localObject == null) {
        localObject = SomeObjectFactory.getById(objectId);
    }
    return localObject;
}