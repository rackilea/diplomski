static class ColorCell extends ListCell<BusinessCard> {

    private final Circle manDone = new Circle(3);
    private final Circle ex = new Circle(3);
    private final HBox circles = new HBox(4, manDone, ex);

    private static final Color EXPORTED_COLOR = Color.web("#808080");
    private static final Color MAN_COLOR = Color.web("#ff9999");
    private static final Color DONE_COLOR = Color.web("#99ff99");

    {
        setGraphic(circles);

        // hide circles
        manDone.setFill(Color.TRANSPARENT);
        ex.setFill(Color.TRANSPARENT);

        setTextFill(Color.BLACK);
    }

    @Override
    public void updateItem(BusinessCard item, boolean empty) {
        super.updateItem(item, empty);

        if (item == null) {
            // hide circles
            manDone.setFill(Color.TRANSPARENT);
            ex.setFill(Color.TRANSPARENT);

            setText(null);
        } else {
            setText(item.toString());

            ex.setFill(item.wasExported() ? EXPORTED_COLOR : Color.TRANSPARENT);
            manDone.setFill(item.hasMand()
                               ? (item.wasExported() ? DONE_COLOR : Color.TRANSPARENT)
                               : MAN_COLOR);
        }
    }
}