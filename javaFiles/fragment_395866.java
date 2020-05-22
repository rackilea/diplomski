public class PasswordNotEmpty extends PasswordRule{
    private String errorString;

    public PasswordNotEmpty(){
        errorString = "Password Should not be empty";
    }

    public boolean check(String password){
        return StringUtils.isEmpty(password);
    }
}