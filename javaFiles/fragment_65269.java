@Name("validator")
@Scope(ScopeType.EVENT)
@BypassInterceptors
public class Validator {

public void positiveInteger(FacesContext context, UIComponent toValidate, Object value) {
        String val = (String) value;

        try {
            int v = Integer.parseInt(val);
            if (v < 0)
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            ((UIInput) toValidate).setValid(false);
            FacesMessages.instance().addToControlFromResourceBundle(toValidate.getId(), "invalid.integer");
        }
    }
}