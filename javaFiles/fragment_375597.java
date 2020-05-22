// Contact con = new Contact(fn, ln, ph, em);
// while(event.getSource() == addButton) {
if (event.getSource() == addButton) {
    fn = firstNameInput.getText();
    ln = lastNameInput.getText();
    ph = phoneInput.getText();
    em = emailInput.getText();
    Contact con = new Contact(fn, ln, ph, em);
    list.add(con); // <-- adds the Contact to the list.  
    firstNameInput.setText("");
    lastNameInput.setText("");
    phoneInput.setText("");
    emailInput.setText("");
}