public class AbstractModel {

    public Object get(String fieldName) throws InvocationTargetException, IllegalAccessException {
        FieldRawValue fieldRawValueAnnotation = validateExistsAndGetFieldRawValueAnnotation(fieldName);

        String fieldRawValueString = fieldRawValueAnnotation.value();

        Optional<Method> getterMethodOptional = Stream.of(getClass().getMethods())
                .filter(method1 -> method1.getName().equalsIgnoreCase("get" + fieldRawValueString))
                .findFirst();

        return getterMethodOptional
                .orElseThrow(() -> new RuntimeException("No getter found for @FieldRawValue with value: " + fieldRawValueString))
                .invoke(this);
    }

    public Object set(String fieldName, Object value) throws InvocationTargetException, IllegalAccessException {
        FieldRawValue fieldRawValueAnnotation = validateExistsAndGetFieldRawValueAnnotation(fieldName);

        String fieldRawValueString = fieldRawValueAnnotation.value();

        Optional<Method> getterMethodOptional = Stream.of(getClass().getMethods())
                .filter(method1 -> method1.getName().equalsIgnoreCase("set" + fieldRawValueString))
                .findFirst();

        return getterMethodOptional
                .orElseThrow(() -> new RuntimeException("No setter found for @FieldRawValue with value: " + fieldRawValueString))
                .invoke(this, value);
    }

    private FieldRawValue validateExistsAndGetFieldRawValueAnnotation(String fieldName) {
        Class<? extends AbstractModel> obj = this.getClass();

        FieldRawValue fieldRawValueAnnotation = null;
        try {
            fieldRawValueAnnotation = obj.getDeclaredField(fieldName).getAnnotation(FieldRawValue.class);
        } catch (NoSuchFieldException e) {
            new RuntimeException("Field not found: " + fieldName);
        }

        if(fieldRawValueAnnotation == null){
            throw new RuntimeException("FieldRawValue annotation not found for a field: " + fieldName);
        }
        return fieldRawValueAnnotation;
    }