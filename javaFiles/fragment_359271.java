listContact.setCellFactory(lv -> new ListCell<Contact>() {
    private Node graphic ;
    private ContactCellController controller ;

    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/boxInContact.fxml"));
            graphic = loader.load();
            controller = loader.getController();
        } catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    protected void updateItem(Contact contact, boolean empty) {
        super.updateItem(contact, empty);
        if (empty) {
            setGraphic(null);
        } else {
            controller.setName(contact.getName());
            controller.setStatus(contact.getStatus());
            controller.setSense(contact.getSense());
            controller.setAvatarImage(contact.getImage());
            setGraphic(graphic);
        }
    }
});