myDialogBox.show();
Scheduler.get().scheduleDeferred(new ScheduledCommand() {

    @Override
    public void execute() {
        myTextBox.setFocus();
    }
});