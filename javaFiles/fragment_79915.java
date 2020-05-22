public class PersonValidator implements ConstraintValidator<ValidPerson, Person> {
    @Override
    public boolean isValid(Person person, ConstraintValidatorContext context) {
        // Add your validation code here
        if (person == null) {
            return true;
        }
        return person.getName() != null;
    }
}