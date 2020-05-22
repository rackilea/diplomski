AlphabetsLv.setCellFactory(alv -> {
        ListCell<String> cell = new ListCell<>();
        cell.textProperty().bind(cell.itemProperty());
        cell.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
            AlphabetsLv.requestFocus();
            if (!cell.isEmpty()) {
                int index = cell.getIndex();
                if (AlphabetsLv.getSelectionModel().getSelectedIndices().contains(index)) {
                    AlphabetsLv.getSelectionModel().clearSelection(index);
                } else {
                    AlphabetsLv.getSelectionModel().select(index);
                }
                event.consume();
            }
        });
        return cell;
    });