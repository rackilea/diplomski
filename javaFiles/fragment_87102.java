// Text field with maximum length
final TextField tf = new TextField("My Eventful Field");
tf.setValue("Initial content");
tf.setMaxLength(20);

// Counter for input length
final Label counter = new Label();
counter.setValue(tf.getValue().length() +
                 " of " + tf.getMaxLength());

// Display the current length interactively in the counter
tf.addTextChangeListener(new TextChangeListener() {
    public void textChange(TextChangeEvent event) {
        int len = event.getText().length();
        counter.setValue(len + " of " + tf.getMaxLength());
    }
});

// The lazy mode is actually the default
tf.setTextChangeEventMode(TextChangeEventMode.LAZY);