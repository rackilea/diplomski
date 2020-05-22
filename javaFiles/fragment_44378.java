final JTextField textField = ...
JButton button = ...
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JPopupMenu popup = new JPopupMenu();
        popup.setLayout(new BorderLayout());
        popup.add(new JPanel()); // your component
        popup.setPopupSize(100, 100);
        popup.show(textField, 0, textField.getHeight());
    }
});