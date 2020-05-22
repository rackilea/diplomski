public static boolean userHasAuthority(String authority)
{
    List<GrantedAuthority> authorities = getUserAuthorities();

    for (GrantedAuthority grantedAuthority : authorities) {
        if (authority.equals(grantedAuthority.getAuthority())) {
            return true;
        }
    }

    return false;
}