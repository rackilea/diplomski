class PhoneNumberConstraint extends AbstractConstraint {
    private static final String NAME = "phoneNumber";
    private static final String DEFAULT_MESSAGE_CODE = "default.phoneNumber.invalid.message";

    @Override
    protected void processValidate(Object target, Object propertyValue, Errors errors) {
        if (!isPhoneNumber(target, propertyValue)) {
            Object[] args = [constraintPropertyName, constraintOwningClass, propertyValue]
            rejectValue(target, errors, DEFAULT_MESSAGE_CODE, DEFAULT_MESSAGE_CODE, args);
        }
    }

    private boolean isPhoneNumber(Object target, Object propertyValue) {
        if(propertyValue instanceof String && ((String)propertyValue).isNumber() &&
                (((String)propertyValue).length() == 13 || ((String)propertyValue).length() == 11)) {
            return true
        }
        return false
    }


    @Override
    boolean supports(Class type) {
        return type != null && String.class.isAssignableFrom(type)
    }

    @Override
    String getName() {
        return NAME
    }
}