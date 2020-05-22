public interface LoginView extends View<LoginController> {

    public String getUserName();
    public char[] getPassword();

    public void loginFailed(String errorMessage);

}