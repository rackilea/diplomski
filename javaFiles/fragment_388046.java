@Documented
@Constraint(validatedBy = MatchesValidator.class)
@Target({ METHOD, CONSTRUCTOR, PARAMETER, FIELD })
@Retention(RUNTIME)
public @interface Matches {
    String message() default "com.example.Matches.message";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String value();
}