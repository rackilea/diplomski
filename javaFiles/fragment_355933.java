public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        JTextField percentField = new JTextField(5);

        // get the JTextField's action and input map
        ActionMap actionMap = percentField.getActionMap();
        int condition = JComponent.WHEN_FOCUSED; // only interested in the input where we have focus
        InputMap inputMap = percentField.getInputMap(condition);

        // get the key for the enter key press in the input map
        Object enterKey = inputMap.get(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));

        // now re-assign its entry in the action map to tab to next component
        actionMap.put(enterKey, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
                manager.focusNextComponent();
            }
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