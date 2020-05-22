boolean authenticate(String username, String password) {
    try {
        DirContext ctx = contextSource.getContext(username, password);
        LdapUtils.closeContext(ctx);
        return true;
    } catch (Exception e) {
        // note: this means an exception was thrown by #getContext() above
        return false;
    }
}