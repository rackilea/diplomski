private final class SpinnerCell extends TableCell<Car, Integer> {
    private final ScrollSpinner<Integer> spinner;

    private SpinnerCell(int min, int max, int initial, int step) {
        spinner = new ScrollSpinner<>();
        spinner.setValueFactory(new IntegerSpinnerValueFactory(min, max, initial, step));
        setEditable(true);
    }

    @Override
    public void startEdit() {
        if (!isEmpty()) {
            super.startEdit();
            spinner.getValueFactory().setValue(getItem());

            setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    Platform.runLater(() -> {
                        commitEdit(spinner.getValue());
                    });
                }
            });

            setText(null);
            setGraphic(spinner);
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText(getItem().toString());
        setGraphic(null);
    }

    @Override
    public void updateItem(Integer item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                setText(null);
                setGraphic(spinner);
            } else {
                setText(getItem().toString());
                setGraphic(null);
            }
        }
    }
}