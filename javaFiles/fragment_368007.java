@Component("preAuthProvider")
public class CustomPreAuthProvider extends PreAuthenticatedAuthenticationProvider {

    @Autowired
    private AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> userService;

    public CustomPreAuthProvider(){
        super();
    }

    @PostConstruct
    public void init(){
        super.setPreAuthenticatedUserDetailsService(userService);
    }
}