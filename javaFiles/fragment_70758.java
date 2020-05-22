ageColumn.setCellFactory(param -> new TableCell<Person, String>(){
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setStyle("");
        } else {
            setText(item);
            Person person = getTableView().getItems().get(getIndex());
            if(person.getName.equals("MATEUS")) {
                setStyle("-fx-background-color: red;");
            } else {
                setStyle("");
            }
        }
    }
});