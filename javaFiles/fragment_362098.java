@Constraint(validatedBy = FraudActionsRestValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidFraudRestRequest {
    String message() default "Invalid Limit of Code";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

public class FraudActionsRestValidator implements ConstraintValidator<ValidFraudRestRequest, FraudActionsRestRequest> {

    @Override
    public void initialize(ValidFraudRestRequest constraintAnnotation) {

    }

    @Override
    public boolean isValid(FraudActionsRestRequest fraudActionsRestRequest, ConstraintValidatorContext constraintValidatorContext) {

        return fraudActionsRestRequest.getTransactionDate() != null && fraudActionsRestRequest.getTransactionTime() != null && additional check you need;
    }
}