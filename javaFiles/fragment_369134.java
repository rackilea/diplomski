public String action() {
    if (password1 != null && password2 != null && password1.equals(password2)) {
        return "connect";
    } else {
        FacesMessage msg = new FacesMessage("Passwords do not match");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
    }
}