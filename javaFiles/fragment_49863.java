@Service
public class CurrentUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userService;

    @Autowired
    public CurrentUserDetailsService(UserRepository userService) {
        this.userService = userService;
    }

    public CurrentUserDetailsService() {

    }

    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        SecurityUser user = userService.findByUsername(username);
        return new CurrentUser(user);
    }
}