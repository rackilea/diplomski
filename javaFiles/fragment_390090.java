reste.setCellFactory(column -> {
    return new TableCell<CommandeFX, Number>() {
        @Override
        protected void updateItem(Number item, boolean empty) {
            super.updateItem(item, empty);

            TableRow<BonFX> currentRow = getTableRow();

            if (empty || item == null) {
                setText("");
                setGraphic(null);
                currentRow.setStyle("-fx-background-color:(****your default color****)");
            } else {
                setText(getItem().toString());
            }

            if (!isEmpty()) {
                if (Float.valueOf((float) item) > 0) {
                    currentRow.setStyle("-fx-background-color:lightcoral");
                }

            }
        }
    };
});