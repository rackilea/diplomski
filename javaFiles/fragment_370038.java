public class SimplePrincipal {

    private String username;
    private List<String> roles = new ArrayList<>();

    public SimplePrincipal(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public boolean isUserInRole(String roleToCheck) {
        return roles.contains(roleToCheck);
    }

    public String getUsername() {
        return username;
    }
}

public class Roles {
    public static final String USER = "USER";
    public static final String ADMIN = "ADMIN";
    public static final String EMPLOYEE = "EMPLOYEE";
}