public void validate(FacesContext context, UIComponent component,
        Object value) throws ValidatorException {
    log.info("validating....!");

    String oldCreditcard = String.valueOf(component.getAttributes().get("oldCreditCardNumber"));
    String newCreditCard = (String) value;
    if(SomeClass.isCorrectCreditcard(newCreditCard)) {
        //You don't need to setValid(false), this is done automatically
        Map<String, String> messages = Messages.instance();
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, messages.get("wrongCreditCardNumber"), messages
                    .get("wrongCreditCardNumber")));

    }
}