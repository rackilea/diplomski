public List<GrantedAuthority> toAuthorities(Set<Role> roles) {
    return roles == null ? new ArrayList<>() : roles.stream()
            .flatMap(role -> role.getPermissions().stream())
            .map(permission -> new SimpleGrantedAuthority("ROLE_" + permission.getLabel()))
            .collect(Collectors.toList());
}