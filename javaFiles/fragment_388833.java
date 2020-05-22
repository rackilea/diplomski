final CheckBoxTableCell<Trainee, Boolean> ctCell = new CheckBoxTableCell<>();
ctCell.setSelectedStateCallback(new Callback<Integer, ObservableValue<Boolean>>() {
    @Override
    public ObservableValue<Boolean> call(Integer index) {
        return table.getItems().get(index).selectedProperty();
    }
});