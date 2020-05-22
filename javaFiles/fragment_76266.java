class ConsumerManagementCommandSpringValidator extends SpringValidator{

Logger log = org.slf4j.LoggerFactory.getLogger(ConsumerManagementCommandSpringValidator.class);

public ConsumerManagementCommandSpringValidator(net.sf.oval.Validator validator) {
    super(validator);
}

/**
 * {@inheritDoc}
 * Overridden method here to handle the nested validated objects of the {@link ConsumerManagementCommand}
 * type. If a nested object fails validation, we need to identify the path to the field using
 * the object name.
 */
@Override
public void validate(final Object objectToValidate, final Errors errors)
{
    try
    {
        for (final ConstraintViolation violation : super.getValidator().validate(objectToValidate))
        {
            final OValContext ctx = violation.getContext();
            final String errorCode = violation.getErrorCode();
            final String errorMessage = violation.getMessage();

            if (ctx instanceof FieldContext) {
                Field field = ((FieldContext) ctx).getField();

                String fieldName = field.getName();
                try{
                    errors.rejectValue(fieldName, errorCode, errorMessage);
                }catch(NotReadablePropertyException nrpe){
                    // Resolve the property location based on the object. Uses the class
                    // name of the field, tweaks the case and concatenates the value
                    StringBuilder objectReference = new StringBuilder(field.getDeclaringClass().getSimpleName());
                    fieldName = objectReference.substring(0, 1).toLowerCase().concat(objectReference.substring(1)).concat(".").concat(fieldName);

                    errors.rejectValue(fieldName, errorCode, errorMessage);
                }
            } else{
                errors.reject(errorCode, errorMessage);
            }
        }
    } catch (final ValidationFailedException ex) {
        log.error("Unexpected error during validation", ex);
        errors.reject(ex.getMessage());
    }
}