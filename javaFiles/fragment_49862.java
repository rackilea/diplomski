public class CurrentUser extends User {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private SecurityUser securityUser;

    public CurrentUser(SecurityUser securityUser) {
        super(securityUser.getUsername(), securityUser.getPassword(), AuthorityUtils.createAuthorityList(securityUser.getRole().toString()));
        this.securityUser = securityUser;
    }

    public SecurityUser getSecurityUser() {
        return securityUser;
    }

    public String getRole() {
        return securityUser.getRole();
    }
}