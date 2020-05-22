private static final String FQCN = MyCustomLogger.class.getName();

...

public void info(Object message) {
    if(repository.isDisabled(Level.INFO_INT))
        return;
    if(Level.INFO.isGreaterOrEqual(this.getEffectiveLevel()))
        forcedLog(FQCN, Level.INFO, message, null);
}

....