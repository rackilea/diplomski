public class LoginBean implements Serializable {

    private String user;
    private String password;

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }

    public void setPassword(String password) {
        System.out.println("Update Password: " + password);
        this.password = password;
    }

    public void setUser(String user) {
        System.out.println("Update User: " + user);
        this.user = user;
    }

    public String login() {
        if ("user".equals(user) && "password".equals(password)) {
            // ok
            System.out.println("Login OK");
            return "loggedIn";
        } else {
            System.out.println("Login Failed");
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage(
                    "Invalid user name or password");
            context.addMessage(null, message);
            return null;
        }
    }

}