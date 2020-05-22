public static boolean hasRole(String role) {
    return getPrincipal().getAuthorities().contains(new SimpleGrantedAuthority(role));
}

public static UserDetails getPrincipal() {
    return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
}