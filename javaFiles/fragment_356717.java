class BaseModel {

    protected void setPrivateFields(Map<String, String> fieldsValuesMap) {
        for (Map.Entry<String, String> entry : fieldsValuesMap.entrySet()) {
            String fieldName = entry.getKey();
            String fieldValue = entry.getValue();

            try {
                Field field = this.getClass().getDeclaredField(fieldName);
                boolean access = field.isAccessible();
                field.setAccessible(true);
                field.set(this, fieldValue);
                field.setAccessible(access);
            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }           
        }
    }

}