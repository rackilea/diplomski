public class ValidCollectionValidator implements ConstraintValidator<ValidCollection, Collection>, ValidatorContextAwareConstraintValidator {

    private static final Logger logger = LoggerFactory.getLogger(ValidCollectionValidator.class);

    private ValidatorContext validatorContext;

    private Class<?> elementType;
    private Class<?>[] constraints;
    private boolean allViolationMessages;

    @Override
    public void setValidatorContext(ValidatorContext validatorContext) {
        this.validatorContext = validatorContext;
    }

    @Override
    public void initialize(ValidCollection constraintAnnotation) {
        elementType = constraintAnnotation.elementType();
        constraints = constraintAnnotation.constraints();
        allViolationMessages = constraintAnnotation.allViolationMessages();
    }

    @Override
    public boolean isValid(Collection collection, ConstraintValidatorContext context) {
        boolean valid = true;

        if(collection == null) {
            //null collection cannot be validated
            return false;
        }

        Validator validator = validatorContext.getValidator();

        boolean beanConstrained = validator.getConstraintsForClass(elementType).isBeanConstrained();

        for(Object element : collection) {
            Set<ConstraintViolation<?>> violations = new HashSet<ConstraintViolation<?>> ();

            if(beanConstrained) {
                boolean hasValidCollectionConstraint = hasValidCollectionConstraint(elementType);
                if(hasValidCollectionConstraint) {
                    // elementType has @ValidCollection constraint
                    violations.addAll(validator.validate(element));
                } else {
                    violations.addAll(validator.validate(element));
                }
            } else {
                for(Class<?> constraint : constraints) {
                    String propertyName = constraint.getSimpleName();
                    propertyName = Introspector.decapitalize(propertyName);
                    violations.addAll(validator.validateValue(CollectionElementBean.class, propertyName, element));
                }
            }

            if(!violations.isEmpty()) {
                valid = false;
            }

            if(allViolationMessages) { //TODO improve
                for(ConstraintViolation<?> violation : violations) {
                    logger.debug(violation.getMessage());
                    ConstraintViolationBuilder violationBuilder = context.buildConstraintViolationWithTemplate(violation.getMessage());
                    violationBuilder.addConstraintViolation();
                }
            }

        }

        return valid;
    }

    private boolean hasValidCollectionConstraint(Class<?> beanType) {
        BeanDescriptor beanDescriptor = validatorContext.getValidator().getConstraintsForClass(beanType);
        boolean isBeanConstrained = beanDescriptor.isBeanConstrained();
        if(!isBeanConstrained) {
            return false;
        }
        Set<ConstraintDescriptor<?>> constraintDescriptors = beanDescriptor.getConstraintDescriptors(); 
        for(ConstraintDescriptor<?> constraintDescriptor : constraintDescriptors) {
            if(constraintDescriptor.getAnnotation().annotationType().getName().equals(ValidCollection.class.getName())) {
                return true;
            }
        }
        Set<PropertyDescriptor> propertyDescriptors = beanDescriptor.getConstrainedProperties();
        for(PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            constraintDescriptors = propertyDescriptor.getConstraintDescriptors();
            for(ConstraintDescriptor<?> constraintDescriptor : constraintDescriptors) {
                if(constraintDescriptor.getAnnotation().annotationType().getName().equals(ValidCollection.class.getName())) {
                    return true;
                }
            }    
        }
        return false;
    }

}