public void doMagicToFields(Object someObject){
    // Get all declared fields.
    Field[] fields = someObject.getClass().getDeclaredFields();
    for(Field field: fields){
        // If the field is annotated by @ExcelColumn
        if(field.isAnnotationPresent(ExcelColumn.class){
            // If the field is a String (add more checks as needed)
            if(String.class.equals(field.getType()){
                // Set the fields value to "myValue" in case of String.
                field.set(someObject, "myValue");
            }
            // Recursive call to check the nested fields of this field object.
            doMagicToFields(
                // We actually get the field object here.
                field.get(someObject)
            );
        }

    }
}