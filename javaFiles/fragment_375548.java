@Documented
@Constraint(
        validatedBy = {CountryCode.CountryCodeValidator.class}
)
@Target({ElementType.METHOD,
        ElementType.FIELD,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CountryCode {

    String message() default "Unknown Country code";

    Class<?>[] groups() default {};

    Class<? extends ValidationErrorType>[] payload() default {};

    /**
     * Validator implementation
     */
     class CountryCodeValidator implements ConstraintValidator<CountryCode, String> {

        private static final Set<String> ISO_COUNTRIES = 
                 new HashSet<String>(Arrays.asList(Locale.getISOCountries()));

        private CountryCode countryCodeAnnotation;

        @Override
        public void initialize(CountryCode countryCodeAnnotation) {
            this.countryCodeAnnotation = countryCodeAnnotation;
        }

        @Override
        public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
            if (s==null) {
                return true;
            }

            return ISO_COUNTRIES.contains(s);
        }
    }
}