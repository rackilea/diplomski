@Override
protected void updateItem(Contact contact, boolean empty) {
    super.updateItem(contact, empty);
    if (contact != null) {
        contactCell.updateContact(contact);
        setGraphic(contactCell);
    } else {
        setGraphic(null);
    }
}