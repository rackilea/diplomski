public class CustomRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        Set<String> authorities = getAuthoritiesOfCurrentUser();
        if(authorities.contains("ROLE_TENANT1")) {
            return "TENANT1";
        }
        return "TENANT2";
    }

    private Set<String> getAuthoritiesOfCurrentUser() {
        if(SecurityContextHolder.getContext().getAuthentication() == null) {
            return Collections.emptySet();
        }
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return AuthorityUtils.authorityListToSet(authorities);
    }
}