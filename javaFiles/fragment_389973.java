public class UpdatedObject {

    private Map<String, Object> updatedFields = 
        new HashMap<String, Object>();

    public boolean containsField(String fieldName) {
        return updatedFields.containsKey(fieldName);
    }

    public void add(String fieldName) {
        updatedFields.put(fieldName, fieldName);        
    }

    public Set<String> getUpdatedFields() {
        return Collections.unmodifiableSet(
                updatedFields.keySet());
    }
}