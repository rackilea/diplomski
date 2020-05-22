final List<String> rolesId = applicationUsers
    .stream()
    .map(ApplicationUser::getAssociationRoles)
    .filter(Objects::nonNull) <------- here!
    .flatMap(List::stream)
    .map(Role::getId)
    .collect(Collectors.toList());