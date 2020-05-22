fxTransactionLogVolume.setCellFactory(col -> {
    TableCell<Trade, Double> cell = new TableCell<Trade, Double>() {
        @Override
        public void updateItem(Double volume, boolean empty) {
            super.updateItem(volume, empty);
            if (empty) {
                setText(null);
            } else {
                setText(volume.toString());
            }
        }
    };

    cell.getStyleClass().add("trade-volume-cell");
    return cell ;
}