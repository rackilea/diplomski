public class StringFormatValidators {

    private static boolean isCommaSeparatedFn(String arg) {
       String COMMA_SEPARATED_STRINGS = "^[a-zA-Z0-9]+[a-zA-Z0-9-_:]*(,[a-zA-Z0-9]+ 
        [a-zA-Z0-9-_:]*)*$";
       Pattern COMMA_SEPARATED_STRINGS_PATTERN = 
       Pattern.compile(COMMA_SEPARATED_STRINGS);
       return arg != null && COMMA_SEPARATED_STRINGS_PATTERN.matcher(arg).find();
    }

    public static final StringFormatValidator isCommaSeparated = 
       StringFormatValidators::isCommaSeparatedFn;
 }