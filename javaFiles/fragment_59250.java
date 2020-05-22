@ConstraintComposition(OR)
@PConstraintA
@ConstraintB
@ReportAsSingleViolation
@Target({ METHOD, FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { })
public @interface ConstraintAOrB {
    String message() default "{com.acme.ConstraintAOrB.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}