private class ButtonCell extends TableCell<Record, Record> {


    private Button cellButton;

    ButtonCell(){
          cellButton = new Button();
        cellButton.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                // do something when button clicked
                Record record = getItem();
                // do something with record....
            }
        });
    }

    //Display button if the row is not empty
    @Override
    protected void updateItem(Record record, boolean empty) {
        super.updateItem(record, empty);
        if(!empty){
            cellButton.setText("Something with "+record.getId());
            setGraphic(cellButton);
        } else {
            setGraphic(null);
        }
    }
}