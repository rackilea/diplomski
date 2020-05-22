@Component
public class BasicAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService registerService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String email = authentication.getName();
        String password = (String) authentication.getCredentials();
        String domain = (String) authentication.getDetails();

        User user = registerService.getUserByEmail(email);

        if (user == null) {
            throw new BadCredentialsException("Username not found.");
        }
        if (!password.equals(user.getPassword()) && !domain.equals(user.getDomain())) {
            throw new BadCredentialsException("Wrong password.");
        }

        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        GrantedAuthority grantedAuthority = new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getAuthority();
            }
        };
        authorities.add(grantedAuthority);

        return new UsernamePasswordAuthenticationToken(email, password, authorities);
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}