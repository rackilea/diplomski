public void exit(int status) {
    SecurityManager security = System.getSecurityManager();
    if (security != null) {
        security.checkExit(status);
    }
    Shutdown.exit(status);
}