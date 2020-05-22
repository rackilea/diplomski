Scheduler.get().scheduleDeferred(new ScheduledCommand() {
        @Override
        public void execute() {
            enableToggleSwitch();
        }
    });