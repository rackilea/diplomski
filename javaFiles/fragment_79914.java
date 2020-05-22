@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { PersonValidator.class })
@Documented
public @interface ValidPerson {

    String message() default "Invalid person";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}