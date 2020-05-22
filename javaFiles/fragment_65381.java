private void reformatPhone(TextBox phoneField) {
    String text = phoneField.getText();
    text = text.replaceAll("\\D+", "");
    if (text.length() == 10) {
        phoneField.setText("(" + text.substring(0, 3) + ") " + text.substring(3, 6) + "-" + text.substring(6, 10));
    }
}


public void onModuleLoad() {
    final TextBox phoneField = new TextBox();

    RootPanel.get("phoneContainer").add(phoneField);
    phoneField.addBlurHandler(new BlurHandler(){
        public void onBlur(BlurEvent event) {
            reformatPhone(phoneField);
        }
    });
}