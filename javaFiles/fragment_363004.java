public class GeneratorPane extends JPanel {

    private TextGeneratorObserver observer;
    private JTextField field;
    private JButton button;

    public GeneratorPane(TextGeneratorObserver observer) {
        this.observer = observer;

        field = new JTextField(10);
        button = new JButton("OK");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                observer.textGenerated(field.getText());
            }
        };

        button.addActionListener(listener);
        field.addActionListener(listener);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(2, 2, 2, 2);

        add(field, gbc);
        add(button, gbc);
    }

}