@Size(max = 20)
@Column(...,length=20)
private String col1;

// and validation itself
ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
validator = factory.getValidator();
Set<ConstraintViolation<Entity>> constraintViolations = validator.validate(entity);