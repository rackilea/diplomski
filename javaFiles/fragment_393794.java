final DateTimeItem dateTimeItem = new DateTimeItem();
    dateTimeItem
            .addChangedHandler(new ChangedHandler() {
                @Override
                public void onChanged(ChangedEvent event) {
                    try {
                        // An exception is throws if an invalid date is entered
                        dateTimeItem.getValueAsDate();
                    } catch (Exception e) {
                        SC.say("Invalid Date");
                    }
                }
            });