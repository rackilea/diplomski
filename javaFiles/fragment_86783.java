final JTextField textField = new JTextField();

btnSubmit.addActionListener(new ActionListener() {

    public void actionPerformed(final ActionEvent e) {
        System.out.println(textField.getText());
    }
});