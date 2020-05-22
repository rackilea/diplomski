public class Transaction {
    @NonNull
    @NotEmpty
    @NumericIbanConstriant 
    private String iban;
}

@Constraint(validatedBy = NumericIbanConstriantValidator.class)
public @interface NumericIbanConstriant {
}

public NumericIbanConstriantValidator implements ConstraintValidator<NumericIbanConstraint, String> {
   // validation logic for iban string being numeric perhaps?
}