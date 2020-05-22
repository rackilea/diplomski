@FacesValidator("passwordValidator")
public class PasswordValidator implements Validator {    

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {


        String password = (String) value;


        UIInput confirmComponent = (UIInput) component.getAttributes().get("confirm");
        String confirm = (String) confirmComponent.getSubmittedValue();

        if (password == null || password.isEmpty() || confirm == null || confirm.isEmpty()) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please confirm password", null);
            throw new ValidatorException(msg);
        }


        if (!password.equals(confirm)) {
            confirmComponent.setValid(false); 
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "The entered passwords do not match", null);
            throw new ValidatorException(msg);
        }


    }