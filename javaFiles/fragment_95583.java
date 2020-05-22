static {
    LOGGER = Logger.getLogger(App.class.getName());
    /*
     * This logic can be externalized. See the next solution!
     */
    // DEPRECATED: LOGGER.setLevel(Level.FINER);
    if (LOGGER.getUseParentHandlers())
        LOGGER.getParent().getHandlers()[0].setLevel(Level.FINER);
    else
        LOGGER.setLevel(Level.FINER);
}