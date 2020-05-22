@Override
    public void commitEdit(String value) {
        super.commitEdit(value);
        ObservableList<String> row = getTableView().getItems().get(getIndex());
        row.set(1, value);
    }