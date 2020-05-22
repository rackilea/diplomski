class CustomTextField extends EditText {
    @Override
    public void setText(String text) {
        super.setText(PersianReshape.reshape(text));
    }
}
[...]
CustomTextField myTextBox = new CustomTextField();
myTextBox.setText("....");