public AccessLevel[] getAccess() {
    String access = "MERIA : SMI";
    return Arrays.stream(access.split(":"))
            .map(String::trim)
            .map(AccessLevel::valueOf)
            .toArray(AccessLevel[]::new);
}