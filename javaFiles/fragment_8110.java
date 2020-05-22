public class MyController {
    @Autowired
    private LDAPAuthenticationProvider ldapProvider;

    public void saveSettings(..) {
         // get the new username and password first
         ldapProvider.setUsername(newUsername);
         ldapProvider.setPassword(newPassword);
    }
}