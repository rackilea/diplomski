public class LoginDTO {
    @SerializedName("log_phno")
    @Expose
    private String user;

    @SerializedName("log_pass")
    @Expose
    private String pass;

    public LoginDTO(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}