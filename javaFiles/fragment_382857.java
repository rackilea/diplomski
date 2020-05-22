public class MyJwtAuthenticationConverter extends JwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    private static final String SCOPE_AUTHORITY_PREFIX = "SCOPE_";

    private static final Collection<String> WELL_KNOWN_SCOPE_ATTRIBUTE_NAMES =
            Arrays.asList("scope", "scp", "authorities"); // added authorities


    protected Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
        return this.getScopes(jwt)
                        .stream()
                        .map(authority -> SCOPE_AUTHORITY_PREFIX + authority)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
    }

    private Collection<String> getScopes(Jwt jwt) {
      Collection<String> authorities = new ArrayList<>();
        // add to collection instead of returning early
        for ( String attributeName : WELL_KNOWN_SCOPE_ATTRIBUTE_NAMES ) {
            Object scopes = jwt.getClaims().get(attributeName);
            if (scopes instanceof String) {
                if (StringUtils.hasText((String) scopes)) {
                    authorities.addAll(Arrays.asList(((String) scopes).split(" ")));
                }
            } else if (scopes instanceof Collection) {
                authorities.addAll((Collection<String>) scopes);
            }
        }

        return authorities;
    }
}