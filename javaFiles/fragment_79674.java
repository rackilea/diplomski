@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PresentOrFutureValidator.class)
@Documented
public @interface PresentOrFuture {
    String message() default "{PresentOrFuture.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}