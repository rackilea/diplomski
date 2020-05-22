public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        JTextField percentField = new JTextField(5);
        percentField.addActionListener(e -> {
            KeyboardFocusManager manager = KeyboardFocusManager
                    .getCurrentKeyboardFocusManager();
            manager.focusNextComponent();
        });

        String[] myData = { "One", "Two", "Three", "Four" };
        JComboBox cb = new JComboBox(myData);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Enter %:"));
        myPanel.add(percentField);
        myPanel.add(Box.createHorizontalStrut(5)); // a spacer
        myPanel.add(new JLabel("Select MA:"));
        myPanel.add(cb);

        String prompt = "Please Select";
        int result = JOptionPane.showConfirmDialog(null, myPanel, prompt,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    });
}