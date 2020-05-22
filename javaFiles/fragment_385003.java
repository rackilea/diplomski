public class TextViewPane extends JPanel implements TextView {

    private JTextField textField;
    private JButton updateButton;
    private List<TextViewObserver> observers;

    public TextViewPane() {
        observers = new ArrayList<>(25);
        textField = new JTextField(25);
        updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireTextWasChanged();
            }
        });

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(textField, gbc);
        add(updateButton, gbc);
    }

    @Override
    public void setText(String text) {
        textField.setText(text);
    }

    @Override
    public String getText() {
        return textField.getText();
    }

    @Override
    public void addTextViewObserver(TextViewObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeTextViewObserver(TextViewObserver observer) {
        observers.remove(observer);
    }

    protected void fireTextWasChanged() {
        for (TextViewObserver observer : observers) {
            observer.textWasChanged(this);
        }
    }

}