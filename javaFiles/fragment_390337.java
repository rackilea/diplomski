@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { VendorNameCheckValidator.class })
@Documented
public @interface VendorNameCheck {

    String message() default "{some.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}



public class VendorNameCheckValidator
        implements ConstraintValidator<ValidPassengerCount, EmployeeDTO> {

    @Override
    public void initialize(VendorNameCheck constraintAnnotation) {
    }

    @Override
    public boolean isValid(EmployeeDTO dto, ConstraintValidatorContext context) {
        if ( dto == null ) {
            return true;
        }

        return !"contractor".equals(dto.getEmployeeType()) || isNotEmpty(dto.getContractVendorName());
    }
}