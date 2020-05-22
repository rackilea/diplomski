public enum UpdatableDtoManager {

    INSTANCE;

    private Map<Object, UpdatedObject> updatedObjects = 
        new HashMap<Object, UpdatedObject>();

    public void updateObjectWithUpdatedField(
            String fieldName, Object object) {
        if (!updatedObjects.containsKey(object)) {
            updatedObjects.put(object, new UpdatedObject());
        }

        UpdatedObject updatedObject = updatedObjects.get(object);
        if (!updatedObject.containsField(fieldName)) {
            updatedObject.add(fieldName);
        }
    }

    public Set<String> getUpdatedFieldsForObject(Object object) {
        UpdatedObject updatedObject = updatedObjects.get(object);

        final Set<String> updatedFields;
        if (updatedObject != null) {
            updatedFields = updatedObject.getUpdatedFields();
        } else {
            updatedFields = Collections.emptySet();
        }

        return updatedFields;
    }
}