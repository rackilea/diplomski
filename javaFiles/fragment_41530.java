public class DateFormatValidatorForString
                           implements ConstraintValidator<DateFormat, String> {

    private String format;

    public void initialize(DateFormat constraintAnnotation) {
        format = constraintAnnotation.value();
    }

    public boolean isValid(
        String date,
        ConstraintValidatorContext constraintValidatorContext) {

        if ( date == null ) {
            return true;
        }

        DateFormat dateFormat = new SimpleDateFormat( format );
        dateFormat.setLenient( false );
        try {
            dateFormat.parse(date);
            return true;
        } 
        catch (ParseException e) {
            return false;
        }
    }
}