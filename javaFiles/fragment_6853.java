ListView<Consultation> notificationList = ... ;

notificationList.setCellFactory(lv -> new ListCell<Consultation>() {
    @Override
    protected void updateItem(Consultation c, boolean empty) {
        super.updateItem(c, empty);
        if (empty) {
            setText(null);
            setStyle("");
        } else {
            setText(": consult reminder - "  + c.getReminderTime());

            // Are you REALLY using an int for the reminderRead property??!?
            // Surely this should be a boolean...

            if (c.getReminderRead() == 1) { // I feel dirty just writing that
                setStyle("-fx-background-color: #33CEFF");
            } else {
                setStyle("");
            }
        }
    }
});

notificationList.getItems().setAll(notifications);