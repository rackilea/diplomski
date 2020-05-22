@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  private UserService userService;

  @Autowired
  private PasswordService passwordService;

  @Override
  public Authentication authenticate(Authentication auth) throws AuthenticationException {
    String username = auth.getName();
    String password = auth.getCredentials().toString();

    User user = userService.getUserWithPermissionsByName(username);
    if (user == null) {
      throw new BadCredentialsException("invalid_username_or_pass");
    }

    if (!passwordService.passwordsMatch(password, user.getPassword())) {
      throw new BadCredentialsException("invalid_username_or_pass");
    }

    String[] permissions = user.getPermissions().stream().map((p) -> p.getName()).toArray(String[]::new);
    List<GrantedAuthority> grantedAuths = AuthorityUtils.createAuthorityList(permissions);
    return new UsernamePasswordAuthenticationToken(new LoggedInUser(user.getName(), user.getPassword(), true, true, true, true, grantedAuths, user.getId()),
        password, grantedAuths);
  }

  @Override
  public boolean supports(Class<?> auth) {
    return auth.equals(UsernamePasswordAuthenticationToken.class);
  }
}