@Override
public UI createInstance(UICreateEvent event) {
    final Class<UIID> key = UIID.class;
    final UIID identifier = new UIID(event);
    CurrentInstance.set(key, identifier);
    try {
        logger.debug(
                "Creating a new UI bean of class [{}] with identifier [{}]",
                event.getUIClass().getCanonicalName(), identifier);
        return webApplicationContext.getBean(event.getUIClass());
    } finally {
        CurrentInstance.set(key, null);
    }
}