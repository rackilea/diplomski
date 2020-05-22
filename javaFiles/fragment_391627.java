class SowInformation extends JFrame implements IUpdateText {
    ...
    private JTextField jTextField4;
    ...
    @Override
    public void updateText(String text) {
        this.jTextfield4.setText(text);
    }
    ...
}