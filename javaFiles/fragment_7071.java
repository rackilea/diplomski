public class SignupForm {

    @Min(6)
    public String password;

    @Min(6)
    public String confirmPassword;

    public String validate() {
        if(!password.equals(confirmPassword)) {
            return "Password mismatch";
        }
        return null;
    }

}