void setTextFieldValue(int index, String value) {
    // assuming the fields belong to the same class as this method
    Class klass = this.getClass(); 
    try {
        Field field = klass.getField("jTextField" + index);
        JTextField text = (JTextField)field.get(this);
        text.setText(value);
    } catch (NoSuchFieldException | IllegalAccessException e) {
        // throw it further, or wrap it into appropriate exception type
        // or just and swallow it, based on your use-case.
        // You can throw a custom checked exception
        // and catch in the caller method to stop the processing 
        // once you encounter index that has no corresponding field
    }
}