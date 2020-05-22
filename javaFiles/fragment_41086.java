public class AddressValidator implements ConstraintValidator<Address, Employee> {

    @Override
    public boolean isValid(Employee emp, ConstraintValidatorContext constraintValidatorContext) {

    // Check for at least one value
    if((emp.getAddress() != null && !emp.getAddress().equals("") ||
            (emp.getCity() != null && !emp.getCity().equals("")) ||
            (emp.getPostcode() != null && !emp.getPostcode().equals("")))) {
        return true;
    }

    return false;
    }
    public void initialize(Address emp) {
          ...
    }
}