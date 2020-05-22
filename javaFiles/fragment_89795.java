public class Bean {

    @NotBlank(groups = Validator.CheckForEmployee.class)
    private String sth1;


    @BlockAccess(groups = Validator.CheckForEmployee.class)
    @NotBlank(groups = Validator.CheckForAdmin.class)
    private String sth2;

    //getters and setters
}

public class Validator {
    public interface CheckForEmployee{}
    public interface CheckForAdmin{}
}


@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BlockAccessImpl.class)
@Documented
public @interface BlockAccess {
    String message() default "Access is denied!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

public class BlockAccessImpl implements ConstraintValidator<BlockAccess, Object> {

    @Override
    public void initialize(BlockAccess constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return false;
    }
}

public class Test {

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Bean b = new Bean();
        b.setSth1("Hi");
        b.setSth2("Bye");

        Set<ConstraintViolation<Bean>> s = validator.validate(b, Validator.CheckForEmployee.class);

        for (ConstraintViolation<Bean> f : s) {
            System.out.println(f.getPropertyPath() + " " + f.getMessage());
        }
    }
}