final String[] nameHolder = new String[1];
myButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            nameHolder[0] = nameTextField.getText();
        }
    });