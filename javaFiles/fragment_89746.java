public void actionPerformed(ActionEvent e) {
     String name = nameTextFeild.getText();
     String surname = surTextField.getText();
     String id = idTextField.getText();

     Account account = new Account(name, surname, id);

     accounts.add(account);
}