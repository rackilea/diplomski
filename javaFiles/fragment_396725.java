public class NotBlankUriValidator implements ConstraintValidator<NotBlankUri, URI> {
    public void initialize(NotBlankUri annotation) {
    }

    public boolean isValid(URI uri, ConstraintValidatorContext context) {
        boolean isValid = true;
        System.out.println("URI: " + uri);
        //Leave null checks to your @NotNull constraint.
        //This is only here to prevent a NullPointerException on the next check.
        if(uri == null){
            return true;
        }
        if(uri.toString().isEmpty()){
            isValid = false;
        }
        return isValid;
    }
}