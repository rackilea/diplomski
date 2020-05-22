public class XRadioButton extends JPanel {

    private JRadioButton radioButton;
    private JLabel label;

    public XRadioButton() {
        setLayout(new GridBagLayout());
        add(getRadioButton());
        add(getLabel());
    }

    public XRadioButton(Icon icon, String text) {
        this();
        setIcon(icon);
        setText(text);
    }

    protected JRadioButton getRadioButton() {
        if (radioButton == null) {
            radioButton = new JRadioButton();
        }
        return radioButton;
    }

    protected JLabel getLabel() {
        if (label == null) {
            label = new JLabel();
            label.setLabelFor(getRadioButton());
        }
        return label;
    }

    public void addActionListener(ActionListener listener) {
        getRadioButton().addActionListener(listener);
    }

    public void removeActionListener(ActionListener listener) {
        getRadioButton().removeActionListener(listener);
    }

    public void setText(String text) {
        getLabel().setText(text);
    }

    public String getText() {
        return getLabel().getText();
    }

    public void setIcon(Icon icon) {
        getLabel().setIcon(icon);
    }

    public Icon getIcon() {
        return getLabel().getIcon();
    }

}