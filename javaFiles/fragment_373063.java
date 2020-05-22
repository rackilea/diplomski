package it.winetsolutions.winactitime.core.service.validation;

import java.beans.PropertyDescriptor;
import java.util.Optional;
import java.util.function.Function;

public class NotExistValidationRule implements ValidationRule {

    Object object;
    String field;
    Function<? super String, ? super Object> function;

    public NotExistValidationRule(Object object, String field, Function<? super String, ? super Object> function) {
        this.object = object;
        if (field == null || field.isEmpty() || function == null) {
            throw new IllegalArgumentException("field and function must not be null or emtpy");
        }
        this.field = field;
        this.function = function;
    }

    @Override public Optional<ValidationError> validate() {

        if (object == null) {
            return Optional.empty();
        }

        try {
            Object value = new PropertyDescriptor(field, object.getClass()).getReadMethod().invoke(object);
            Long id = (Long) new PropertyDescriptor("id", object.getClass()).getReadMethod().invoke(object);
            Object result = function.apply(value == null ? (String) value : ((String) value).trim());
            if (result != null &&
                !id.equals((Long) new PropertyDescriptor("id", result.getClass()).getReadMethod().invoke(result))) {
                ValidationError validationError = new ValidationError();
                validationError.setName(object.getClass().getSimpleName() + "." + field);
                validationError.setError("Element with " + field +": " + value + " already exists");
                return Optional.of(validationError);
            }
        }
        catch (Exception e) {
            throw new IllegalStateException("error during retrieve of field value");
        }

        return Optional.empty();
    }
}