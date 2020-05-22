public class NotNullValidationRule implements ValidationRule {

    private Object object;
    private String field;

    public NotNullValidationRule(Object object, String field) {
        this.object = object;
        if (field == null || field.isEmpty()) {
            throw new IllegalArgumentException("field must not be null or emtpy");
        }
        this.field = field;
    }

    @Override public Optional<ValidationError> validate() {

        if (object == null) {
            return Optional.empty();
        }

        try {
            Object value = new PropertyDescriptor(field, object.getClass()).getReadMethod().invoke(object);
            if (value == null) {
                ValidationError validationError = new ValidationError();
                validationError.setName(object.getClass().getSimpleName() + "." + field);
                validationError.setError("Field " + field + " is null");
                return Optional.of(validationError);
            }
        }
        catch (Exception e) {
            throw new IllegalStateException("error during retrieve of field value");
        }

        return Optional.empty();
    }
}