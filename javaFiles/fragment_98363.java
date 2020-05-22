public static boolean isAdmin() {
    String groups[] = (new com.sun.security.auth.module.NTSystem()).getGroupIDs();
    for (String group : groups) {
        if (group.equals("S-1-5-32-544"))
            return true;
    }
    return false;
}