@Override
public boolean isValid(String name, ConstraintValidatorContext context) {
    return HttpMethod.PUT.name().equals(request.getMethod()) || 
           validate(name, context);
}

private boolean validate(String name, ConstraintValidatorContext context) {
    // validate name uniqueness
    return false;
}