public abstract class PasswordRule{
    private String errorString;

    abstract public boolean check(String password){
        //implement the rule
    }

    public String getError(){
        return errorString;
    }
}