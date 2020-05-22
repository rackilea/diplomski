Scheduler.get().scheduleDeferred(new ScheduledCommand() {

    @Override
    public void execute() {
        Integer maxWidth = getOffsetWidth();
        Integer maxHeight = getOffsetHeight(); 
        // etc.
    }
});