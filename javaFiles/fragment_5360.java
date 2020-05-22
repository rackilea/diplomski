@Component
public class JasperUserManagerImpl implements JasperUserManager {

    @Resource(name="")
    private UserAuthorityService userAuthorityService;

    @Override
    public void saveUser() {
        User user = userAuthorityService.newUser(null);
        user.setUsername("thusira");
        user.setTenantId("ACT");
        user.setPassword("123");
        user.setFullName("Thusira Dissanayake");
        user.setEnabled(true);
        user.setExternallyDefined(false);
        userAuthorityService.putUser(null, user);  
    }
}