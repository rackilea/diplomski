public static final String localize(final Locale locale, final String key, final Object... param) {
    final String name = "message";
    final ResourceBundle rb;

    /* Resource bundles are cached internally,
       never saw a need to implement another caching level
     */
    try {
        rb = ResourceBundle.getBundle(name, locale, Thread.currentThread()
                .getContextClassLoader());
    } catch (MissingResourceException e) {
        throw new RuntimeException("Bundle not found:" + name);
    }

    String keyValue = null;

    try {
        keyValue = rb.getString(key);
    } catch (MissingResourceException e) {
        // LOG.severe("Key not found: " + key);
        keyValue = "???" + key + "???";
    }

    /* Message formating is expensive, try to avoid it */
    if (param != null && param.length > 0) {
        return MessageFormat.format(keyValue, param);
    } else {
        return keyValue;
    }
}