if (!emailMatcher.matches() && !passwordMatcher.matches()) {
    if (authentificationEJB.checkCredentials(emailInput, passwordInput) == false) {
        FacesMessage msg = new FacesMessage(
                "Pogresan email ili lozinka");
        throw new ValidatorException(msg);
    }
}