public class Account{

    @NotNull(message="This field should not be null")
    private String username;
    @NotBlank(message="This string should not be empty or null")
    private String password;
    private String name;
    private String mail;


    public void setUserName(String username){
        this.username = username;
    }

    public String getUserName(){
        return username;
    }

    [all other getter/Setter...]
}