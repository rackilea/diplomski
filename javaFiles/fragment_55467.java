public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    //I suppose it's a typo, but your validate method lacks the return type.
    String username = (String) value;
    UIInput passwordInput = component.getAttributes().containsKey("pass") ? 
        (UIInput) component.getAttributes().get("pass") : null;
    if(passwordInput != null) {
        //Just to be sure the input was added as a parameter successfuly
        String submittedPassword = passwordInput.getSubmittedValue();
        //Now, do your validations based on the strings "username"
        //and "password".
    }
}