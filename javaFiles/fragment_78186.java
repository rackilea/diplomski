TableColumn thirdColumn = new TableColumn("Third Column");  
    thirdColumn.setCellValueFactory(new PropertyValueFactory<TableData,String>("three"));

    // ** The TableCell class has the method setTextFill(Paint p) that you 
    // ** need to override the text color
    //   To obtain the TableCell we need to replace the Default CellFactory 
    //   with one that returns a new TableCell instance, 
    //   and @Override the updateItem(String item, boolean empty) method.
    //
    thirdColumn.setCellFactory(new Callback<TableColumn, TableCell>() {
        public TableCell call(TableColumn param) {
            return new TableCell<TableData, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                        this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains("@")) 
                            this.setTextFill(Color.BLUEVIOLET);
                        setText(item);
                    }
                }
            };
        }
    });