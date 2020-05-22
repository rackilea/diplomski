public class InputPane extends JPanel {

    private final JTextField minField;
    private final JTextField maxField;

    public InputPane() {
        minField = new JTextField(5);
        maxField = new JTextField(5);
        add(new JLabel("Min: "));
        add(minField);
        add(new JLabel("Max: "));
        add(maxField);
    }

    public String getMaxValue() {
        return maxField.getText();
    }

    public String getMinValue() {
        return minField.getText();
    }

    public void setMaxValue(String value) {
        maxField.setText(value);
    }

    public void setMinValue(String value) {
        minField.setText(value);
    }

}