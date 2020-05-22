String name = nameTextField.getText();
String eMail = eMailTextField.getText();
String dateOfBirth = dateOfBirthTextField.getText();
String address = addressTextField.getText();

DefaultListModel model = (DefaultListModel)list.getModel();
model.add(new Data(name, eMail, dateOfBirth, address));