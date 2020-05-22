public class DateFieldWithValidator extends VerticalLayout {

    public DateFieldWithValidator() {
        // date field with binder
        Binder<LocalDate> binder = new Binder<>();
        DateField dateField = new DateField("Date");
        binder.forField(dateField)
              .asRequired("Please select a date")
              .bind(No.getter(), No.setter());

        // validity status
        TextField validityField = new TextField("Status:", "N/A");
        validityField.setReadOnly(true);
        validityField.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        validityField.setWidth("100%");

        // submit button
        Button submitButton = new Button("Submit");
        submitButton.addClickListener(event -> {
            BinderValidationStatus<LocalDate> status = binder.validate();
            if (status.isOk()) {
                validityField.setValue("OK: " + dateField.getValue().toString());
            } else {
                validityField.setValue("KO: " + status.getValidationErrors().stream().map(ValidationResult::getErrorMessage).collect(Collectors.joining(",")));
            }
        });

        addComponents(dateField, submitButton, validityField);
    }

    // convenience empty getter and setter implementation for better readability
    public static class No {
        public static <SOURCE, TARGET> ValueProvider<SOURCE, TARGET> getter() {
            return source -> null;
        }

        public static <BEAN, FIELDVALUE> Setter<BEAN, FIELDVALUE> setter() {
            return (bean, fieldValue) -> {
                //no op
            };
        }
    }
}