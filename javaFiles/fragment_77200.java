powerColumn.setCellFactory(tc -> new TableCell<Area, Double>() {
    @Override
    protected void updateItem(Double power, boolean empty) {
        super.updateItem(power, empty);
        if (empty) {
            setText(null);
        } else {
            setText(String.format("%.0f", power.doubleValue()));
        }
    }
});