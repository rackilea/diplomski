btnEdi.addActionListener(new ActionListener() {
    @Override // don0t forget @Override annotation
    public void actionPerformed(ActionEvent ae) {
        desktop.open(txtText.getText()); // here
    }
});