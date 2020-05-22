for (Map.Entry<String, Object> entry : acceptableParameters.entrySet()) {
    String name = entry.getKey();
    Object value = entry.getValue();
    try {
        newStack.setParameter(name, value);
    } catch (RuntimeException e) {
        if (devMode) {
            String developerNotification = LocalizedTextUtil.findText(ParametersInterceptor.class, "devmode.notification", ActionContext.getContext().getLocale(), "Developer Notification:\n{0}", new Object[]{
                     "Unexpected Exception caught setting '" + name + "' on '" + action.getClass() + ": " + e.getMessage()
            });
            LOG.error(developerNotification);
            if (action instanceof ValidationAware) {
                ((ValidationAware) action).addActionMessage(developerNotification);
            }
        }
    }
}