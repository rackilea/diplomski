@Override
public boolean isValid(final Object value, final ConstraintValidatorContext context) {
    if (fields.length > 0) {
        final BeanWrapperImpl beanWrapper = new BeanWrapperImpl(value);
        final Object comparisonValue = beanWrapper.getPropertyValue(fields[0]);

        for (int i = 1; i < fields.length; i++) {
            if (!comparisonValue.equals(beanWrapper.getPropertyValue(fields[i]))) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(fields[0]).addConstraintViolation();
                return false;
            }
        }
    }

    return true;
}