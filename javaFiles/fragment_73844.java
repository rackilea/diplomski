myButton.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent e) {
        String whatToSearch = myTextField.getText();
        String result = yourSearchMethod(whatToSearch);
        // use the fitting method of JOptionPane to display the result
    }
}