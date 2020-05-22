@Override
public boolean supports(final Class<?> clazz)
{
    return HashMap.class.equals(clazz);
}
@Override
public void validate(final Object target, final Errors errors)
{
    ValidationUtils.rejectIfEmpty(errors, "transactionId", "field.required");
    ValidationUtils.rejectIfEmpty(errors, "checksum", "field.required");

    final Map<String, String> response = (HashMap<String, String>) target;
    // do custom validations with the map's attributes
    // ....
    // if validation fails, reject the whole map - 
         errors.reject("response.map.invalid");
}