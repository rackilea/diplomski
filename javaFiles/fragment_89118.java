ServiceReference<?> logreser = bundleContext.getServiceReference(LogReaderService.class);
LogReaderService lrs = (LogReaderService) bundleContext.getService(logreser);   
lrs.addLogListener(new LogListener() {
    @Override
    public void logged(LogEntry entry) {
        System.err.println("Something was logged: " + entry.getMessage());
    }
});