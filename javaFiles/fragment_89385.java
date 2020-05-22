public class JsonStringValidator implements ConstraintValidator<JsonString, String> {

    @Override
    public void initialize(JsonString jsonString) { }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext context) {
        // Use an implementation from step 1. A brief example:
        try {
            new JsonParser().parse(string);
            return true;                    // valid JSON, return true
        } catch (JsonSyntaxException ex) { 
            /* exception handling if needed */
        }
        return false;                       // invalid JSON, return false
    }
}