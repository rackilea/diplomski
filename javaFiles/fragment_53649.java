@RequestScoped
public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
    @Inject
    CustomerResource customerResource;

    @Override
    public boolean isValid(String vTelephone, ConstraintValidatorContext pContext) {
        // Get the country in here using the original resource instance
        final String vCountry = customerResource.getHeaderString("COUNTRY");
        try {
            validate(vTelephone, vCountry);
        } catch (Throwable t) {
            System.out.printf("Error parsing {0} as a phone number in {1}: {2}", vTelephone, vCountry, t.getMessage());
            return false;
        }
        return true;
    }
...