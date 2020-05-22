@GetMapping("/users")
public Collection<String> findUsers() {
    return sessionRegistry
        .getAllPrincipals()
        .stream()
        .map(this::getUsername)
        .flatMap(Optional::stream)
        .collect(toList());
}

private Optional<String> getUsername(Object principal) {
    if (principal instanceof UserDetails) {
        return Optional.ofNullable(((UserDetails) principal).getUsername());
    } else {
        return Optional.empty();
    }
}