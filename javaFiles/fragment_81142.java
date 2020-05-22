public String login() {
    User user = userService.find(username, password); 

    if (user != null) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
        return "success?faces-redirect=true";
    } else {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
            FacesMessage.SEVERITY_WARN, "Unknown login, please try again.", null));
        return null;
    }
}