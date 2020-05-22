if (confirm()) {
    Customer new = new Customer(nameField.getText(),new Address(streetField.getText(),
    cityField.getText(), stateField.getText(), Integer.parseInt(zipField.getText())),
    Integer.parseInt(accountNumberField.getText()));

    int existing = -1;
    if ((existing = customerList.indexOf(new)) != -1) {
        Customer old = customerList.get(existing);
        // Add course to existing customer
    } else {
        customerList.add(new);
    }
}