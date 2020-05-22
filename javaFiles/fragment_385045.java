FObjectDialog fod = new FObjectDialog(this);
fod.setLocationRelativeTo(this); // A model doesn't set its location automatically relative to its parent  
fod.setVisible(true);
// Now this code doesn't continue until the dialog is closed again.
// So the next code will be executed when it is closed and the data is filled in.
String name = fod.getName();
String text = fod.getText();
// getName() and getText() are just two simple getters (you still have to make) for the two fields their content
// So return textField.getText();