private void setListBoxValues(final Map<String, String> theValues) {
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
            @Override
            public void execute() {
                clear();
                for (Entry<String, String> entry : theValues.entrySet()) {
                    box.addItem(entry.getValue(), entry.getKey());
                }
            }
        });
    }