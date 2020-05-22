public static String setProperty(String key, String value) {
    checkKey(key);
    SecurityManager sm = getSecurityManager();
        if (sm != null) {
        sm.checkPermission(new PropertyPermission(key,
        SecurityConstants.PROPERTY_WRITE_ACTION));
    }

    return (String) props.setProperty(key, value);
}