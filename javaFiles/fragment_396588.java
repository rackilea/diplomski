comboBox.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        dispose();
        // Share the selected item with Main.class
        // Callback
        execute(comboBox.getSelectedItem());
    }
});