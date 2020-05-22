public class FutureCustomImpl  implements ConstraintValidator<FutureCustom, Date> {

    private String max;

    @Override
    public void initialize(FutureCustom constraintAnnotation) {
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        //Validation using value and max like parameter in annotation
            // The max attribute will always be a String, you have to convert it to Date.
    }

}