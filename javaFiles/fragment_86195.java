public class PasswordData {
    private String _password;
    private String _username;

    public PasswordData(String password, String username)
    {
        _password = password;
        _username = username;
    }

    public String getUsername()
    {
        return _username;
    }

    public void setUsername(String username)
    {
        _username = username;
    }

    public String getPassword()
    {
        return _password;
    }

    public void setPassword(String password)
    {
        _password = password;
    }
}

public class StackOverflowPasswordExample {
    private static PasswordData cn;

    public static void main(String[] args) {
        cn = new PasswordData("mypassword", "myusername");
        boolean auth = authenticate();
        System.out.println("authenticated is " + auth);
    }

    public static boolean authenticate() { 
        String g2 = cn.getPassword();
        String h2 = cn.getUsername(); 

        return g2 != null && h2 != null;
    } 

}