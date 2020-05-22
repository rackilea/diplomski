if (permission instanceof String) {
    String permString = (String) permission;
    Permission p;

    try {
        p = permissionFactory.buildFromName(permString);
    }
    catch (IllegalArgumentException notfound) {
        p = permissionFactory.buildFromName(permString.toUpperCase());
    }

    if (p != null) {
        return Arrays.asList(p);
    }

}