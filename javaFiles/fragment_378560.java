context.addInstallerEventListener(new InstallerEventListener() {
    @Override
    public void installerEvent(InstallerEvent event) {
        if (event.getType() == EventType.BEFORE_EXECUTE_ACTION) {
            Util.logError(event.getSource(), "Started action at " +
              DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM)
               .format(new Date()));
        }
    }
});