okButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        ...
        ((DefaultTableModel)table.getModel()).addRow(...);
        ...
    }
};