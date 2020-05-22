public UI createInstance(UICreateEvent event) {
    try {
        return event.getUIClass().newInstance();
    } catch (InstantiationException e) {
        throw new RuntimeException("Could not instantiate UI class", e);
    } catch (IllegalAccessException e) {
        throw new RuntimeException("Could not access UI class", e);
    }
}