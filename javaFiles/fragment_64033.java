@Component
    private Form myForm;
    ...
    @OnEvent(value = EventConstants.VALIDATE, component = "myForm")
    public void onCreateEditValidate() {
       // do validation and if any error record it
       myForm.record(theDateField, "Dang, try again!");
       ...