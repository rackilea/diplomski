public class CustomAuthorityProvider implements AuthenticationProvider {

private AuthenticationProvider delegate;

public CustomAuthorityProvider(AuthenticationProvider delegate) {
    this.delegate = delegate;
}

public Authentication authenticate(Authentication authentication) {

    final Authentication a = delegate.authenticate(authentication);

    // Load additional authorities and create an Authentication object
    final List<GrantedAuthority> authorities = getGrantedAuthorities(a.getName());

    return new UsernamePasswordAuthenticationToken(a.getPrincipal(),a.getCredentials(),authorities);
}

@Override
public boolean supports(Class<?> authentication) {
    return delegate.supports(authentication);
}

List<GrantedAuthority> getGrantedAuthorities(String username) {
    JdbcTemplateDataSource ds = new JdbcTemplateDataSource();
    List<GrantedAuthority> roles = ds.getJdbcTemplate().query("select r.Role from Users u join UserRole ur on u.UserId = "
            + "ur.UserId join Roles r on r.RoleId = ur.RoleId where Username = ?",
            new String[]{username},
            new RowMapper<GrantedAuthority>() {
                public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new SimpleGrantedAuthority(rs.getString(1));
                }
            });
    return roles;
}
}