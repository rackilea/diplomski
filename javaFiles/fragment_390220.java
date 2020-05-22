public class DateFieldWithValidator extends VerticalLayout {
    public DateFieldWithValidator() {
        DateField dateField = new DateField("Date");
        Button submitButton = new Button("Submit");
        submitButton.setEnabled(false);
        submitButton.addClickListener(event -> Notification.show("Selected date: " + dateField.getValue()));
        dateField.setRequiredIndicatorVisible(true);
        dateField.setErrorHandler(event -> submitButton.setEnabled(false));
        dateField.addValueChangeListener(event -> submitButton.setEnabled(event.getValue() != null));
        addComponents(dateField, submitButton);
    }
}