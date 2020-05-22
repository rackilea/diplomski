lanSpecie.setCellFactory(column -> new TableCell<HAUL, Specie>() {
    private final ComboBox<Specie> comboBox = new ComboBox<>();

    {
        comboBox.setItems(FXCollections.observableList(specieService.findAllAdded()));
        comboBox.setOnAction(e -> commitEdit(comboBox.getValue()));
    }

    @Override
    protected void updateItem(Specie specie, boolean empty) {
        super.updateItem(specie, empty);
        if (empty) {
            setGraphic(null);
        } else {
            comboBox.setValue(specie);
            setGraphic(comboBox);
        }
    }
});

lanSpecie.setOnEditCommit(event -> {
    HAUL haul = event.getRowValue();
    haul.setSpecie(event.getNewValue());
});