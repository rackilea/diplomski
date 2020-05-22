@Target({ METHOD, FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotBlankUriValidator.class)
@NotBlank    
public @interface NotBlankUri {
    String message() default "{project.model.NotBlankUri.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}