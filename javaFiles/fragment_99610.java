@Documented
@Constraint(validatedBy = OrderIdValidator.class)
@Target({PARAMETER})
@Retention(RUNTIME)
public @interface ValidOrderId {
    String message() default "Invalid order ID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}