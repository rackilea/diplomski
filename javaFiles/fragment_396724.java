@NotNull(message="URI must not be null")
@Target({ METHOD, FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotBlankUriValidator.class)
public @interface NotBlankUri {
    String message() default "URI must not be blank";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}