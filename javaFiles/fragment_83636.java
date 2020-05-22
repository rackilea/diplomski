@NotNull
@Size(min=4)
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { })
@Documented
public @interface JPasswordConstraint {
    String message() default "Password is invalid";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
 }