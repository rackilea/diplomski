if (null != roles) {
    authorities = roles.stream()
         .flatMap(role -> role.getPermissions().stream()) // Stream<Permission>
         .map(permission -> 
                 new SimpleGrantedAuthority("ROLE_" + permission.getLabel())) // Stream<SimpleGrantedAuthority>
         .collect(Collectors.toList());
}