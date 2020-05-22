@Target( {ElementType.FIELD})
@Retention( RetentionPolicy.RUNTIME)
@Constraint( validatedBy = ValidatePostalCodeImpl.class)
public @interface ValidatePostalCode{
  String message() default "You have entered an invalid postal code";
  Class<?>[] groups() default {}; // needed for the validation
  Class<? extends Payload>[] payload() default{}; // needed for the validation

  int maxValue() default 9999; // so, by default, this will validate based
  int minValue() default 1000; // on these values, but you will be able to 
  // override these
}