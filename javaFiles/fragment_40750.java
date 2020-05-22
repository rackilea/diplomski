return roles == null ? new ArrayList<>() : roles.stream()
        .map(Role::getPermissions)
        .flatMap(Collection::stream)
        .map(Permission::getLabel)
        .map("ROLE_"::concat)
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toList());