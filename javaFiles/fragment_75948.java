public class MyFieldValidator implements ConstraintValidator<Field, Object> {

    private int order;

    @Override
    public void initialize(Field annotation) {

        this.order = annotation.order();

        if (this.order < 0) {
          // blow up
        }
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintContext) {

        return true;
    }
}