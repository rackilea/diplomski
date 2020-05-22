public class EntityValidator 
{
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    public Set<ConstraintViolation<Category>> validateCategory(Category category)
    {
        return validator.validate(category);
    }
}