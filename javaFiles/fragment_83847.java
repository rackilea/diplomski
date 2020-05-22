public class ConstraintValidatorFactoryImpl implements ConstraintValidatorFactory {

    private ValidatorContext validatorContext;

    public ConstraintValidatorFactoryImpl(ValidatorContext nativeValidator) {
        this.validatorContext = nativeValidator;
    }

    @Override
    public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {
        T instance = null;

        try {
            instance = key.newInstance();
        } catch (Exception e) { 
            // could not instantiate class
            e.printStackTrace();
        }

        if(ValidatorContextAwareConstraintValidator.class.isAssignableFrom(key)) {
            ValidatorContextAwareConstraintValidator validator = (ValidatorContextAwareConstraintValidator) instance;
            validator.setValidatorContext(validatorContext);
        }

        return instance;
    }

}