private void save() {
    SaveObject obj = new SaveObject();

    obj.setStringOne(stringFieldOne.getText());
    obj.setStringTwo(stringFieldTwo.getText());

    List<string> validationErrors = obj.validate();

    if (validationErrors.length > 0) {
        // do whatever you need to do, e.g. throw an exception, or render the
        // messages.
    }
}