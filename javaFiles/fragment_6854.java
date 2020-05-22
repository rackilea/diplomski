ListView<Consultation> notificationList = ... ;

PseudoClass reminderRead = PseudoClass.getPseudoClass("reminder-read");

notificationList.setCellFactory(lv -> new ListCell<Consultation>() {
    @Override
    protected void updateItem(Consultation c, boolean empty) {
        super.updateItem(c, empty);
        if (empty) {
            setText(null);
        } else {
            setText(": consult reminder - "  + c.getReminderTime());
        }

        // assumes Consultation.getReminderRead() returns a boolean...
        pseudoClassStateChanged(reminderRead, c != null && c.getReminderRead())
    }
});

notificationList.getItems().setAll(notifications);