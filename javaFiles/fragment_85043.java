ButtonCell(String text){
          cellButton = new Button();
        cellButton.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                // do something when button clicked
                Record record = (Record) getTableRow().getItem();
                // do something dependent on record....
            }
        });
    }
    //Display button if the row is not empty
    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if(!empty){
            final Record record = (Record)getTableRow().getItem();
            cellButton.setText("Do something with "+record.getId());
            setGraphic(cellButton);
        } else { // you must always do the following in cell subclasses:
            setGraphic(null);
        }
    }