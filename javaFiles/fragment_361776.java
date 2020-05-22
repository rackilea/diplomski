public class Main {
    public static void main(String[] args) {
        OuterPojo outer = new OuterPojo("some value", null);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator v = factory.getValidator();
        Set<ConstraintViolation<OuterPojo>> errors = v.validate(outer);
        for (ConstraintViolation<OuterPojo> violation : errors) {
            System.out.println(violation.getMessage());
        }
    }
}