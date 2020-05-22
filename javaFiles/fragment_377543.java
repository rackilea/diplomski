Consumer<String> nameConsumer = text -> { /*You will handle event here*/};
myButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            nameConsumer.apply(nameTextField.getText());
        }
    });