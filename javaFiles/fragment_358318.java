public void update(Observable o, Object arg) {
    try {
        Method update = getClass().getMethod("onAction", arg.getClass());
        update.invoke(this, arg);
    } catch (NoSuchMethodException e) {
        LOGGER.error("No onAction for <" + arg.getClass().getSimpleName() + "> action.");
        LOGGER.catching(e);
    } catch (Exception e) {
        LOGGER.catching(e);
    }
}