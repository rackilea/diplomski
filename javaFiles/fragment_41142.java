btnDelete.setOnAction(new EventHandler<ActionEvent>() {

    @Override
    public void handle(ActionEvent event) {
        param.getTableView().getSelectionModel().select(getIndex());
        Person item = personTable.getSelectionModel().getSelectedItem();
        if (item != null) {
            // Logic of deleting current record here
            System.out.println(item.getName());
        }
    }
});