static String tmp;

static {
    try {
        tmp = System.getenv("TEMP");
    } catch (java.security.AccessControlException ace) {
        // tmp is not set, maybe use some default value?
    }
}