private static final ThreadLocal<Locale> threadLocale = new ThreadLocal<Locale>();

...

public String translate(String translationKey, Locale aLocale, Object ...parameters) {

    Locale previousLocale = threadLocale.get();
    try {
        threadLocale.set(aLocale);
        return new MessageFormat( translationKey, aLocale ).format( parameters);
        ...
    } finally {
        threadLocale.set(previousLocale);
    }
}

// somewhere in toString method threadLocale.get() will return you current Locale