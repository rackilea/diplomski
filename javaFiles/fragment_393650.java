@FacesValidator("customValidator")
public class CustomValidator implements Validator{

    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
        // do your validation here
    }
}