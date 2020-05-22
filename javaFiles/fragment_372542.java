colAction.setCellFactory(col -> {
    return new TableCell<String, Boolean>() {
        Button SaveButton = new Button("Save");
        Button AddButton = new Button("Add");
        Button RefreshButton = new Button("Refresh");
        Button EditButton = new Button("Edit");

        HBox hboxBuilding = new HBox(5);
        HBox hboxSearch = new HBox(5);

        {
            hboxBuilding.getChildren().addAll(AddButton,EditButton);
            hboxSearch.getChildren().addAll(SaveButton,RefreshButton);
        }

        @Override
        protected void updateItem(Boolean item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setGraphic(null);
            }
            else {
                setGraphic(item ? hboxBuilding : hboxSearch);
            }
        }
    };
});