checkedCol.setCellFactory(CheckBoxTableCell.forTableColumn(new Callback<Integer, ObservableValue<Boolean>>() {

    @Override
    public ObservableValue<Boolean> call(Integer param) {
        System.out.println("Cours "+items.get(param).getCours()+" changed value to " +items.get(param).isChecked());
        return items.get(param).checkedProperty();
    }
}));