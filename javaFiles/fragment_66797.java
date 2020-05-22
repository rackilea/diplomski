TableColumn<Member, Boolean> installmentsColumn = ...;
installmentsColumn.setCellValueFactory(cd -> cd.getValue().collectedProperty());
installmentsColumn.setCellFactory(column -> new TableCell<Member, Boolean>() {

    private final Button button = new Button("View Info");

    {
        button.setOnAction(evt -> {
            Member member = (Member) getTableRow().getItem();

            // TODO: handle button click
        });
    }

    @Override
    protected void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setGraphic(null);
        } else {
            setGraphic(button);
            button.setDisable(!item);
        }
    }
});