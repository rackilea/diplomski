public AccessLevel[] getAccess() {
    String access = "MERIA : SMI";
    String[] split = access.split("\\s*:\\s*");
    AccessLevel[] accessLevels = new AccessLevel[split.length];
    for (int i = 0; i < split.length; i++) {
        accessLevels[i] = AccessLevel.valueOf(split[i]);
    }
    return accessLevels;
}