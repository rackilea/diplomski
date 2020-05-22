final DateTimeItem dateTimeItem = new DateTimeItem();
final DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("MM/dd/yyyy");
final DateDisplayFormat dateDisplayFormat = DateDisplayFormat.TOUSSHORTDATE;

dateTimeItem.setDateFormatter(dateDisplayFormat);
dateTimeItem.setTitle("Date");
CustomValidator dateValidator = new CustomValidator() {

    @Override
    protected boolean condition(Object value) {
        try {
            // An exception is throws if an invalid date is entered
            dateTimeFormat.format((Date) value);
        } catch (Exception e) {                
            return false;
        }
        return true;
    }

};
dateValidator.setErrorMessage("Invalid date");
dateTimeItem.setValidators(dateValidator);
dateTimeItem.setValidateOnChange(true);