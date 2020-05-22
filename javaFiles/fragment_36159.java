public static void setErr(PrintStream err) {
    checkIO();
    setErr0(err);
}

private static void checkIO() {
    SecurityManager sm = getSecurityManager();
    if (sm != null) {
        sm.checkPermission(new RuntimePermission("setIO"));
    }
}