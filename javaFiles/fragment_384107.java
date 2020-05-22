@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = AllOrNoneValidator.class)
public @interface AllOrNone {
    String[] value();

    String message() default "{AllOrNone.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

public class AllOrNoneValidator implements ConstraintValidator<AllOrNone, Object> {
    private static final SpelExpressionParser PARSER = new SpelExpressionParser();
    private String[] fields;

    @Override
    public void initialize(AllOrNone constraintAnnotation) {
        fields = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        long notNull = Stream.of(fields)
                .map(field -> PARSER.parseExpression(field).getValue(value))
                .filter(Objects::nonNull)
                .count();
        return notNull == 0 || notNull == fields.length;
    }
}