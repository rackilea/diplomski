Scheduler.get().scheduleDeferred(new ScheduledCommand() {    
  @Override
  public void execute() {
    // request data from server
    // update ui
    Scheduler.get().scheduleDeferred(this); // reschedule
  }
});