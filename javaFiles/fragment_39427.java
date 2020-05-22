table.setRowFactory(new Callback<TableView<Person>, TableRow<Person>>() {  
        @Override  
        public TableRow<Person> call(TableView<Person> tableView) {  
            final TableRow<Person> row = new TableRow<>();  
            final ContextMenu contextMenu = new ContextMenu();  

            row.itemProperty().addListener((obs, oldPerson, newPerson) -> {
                contextMenu.getItems().clear();
                // add items to context menu depending on value of newPerson
                // ...
            });

           // Set context menu on row, but use a binding to make it only show for non-empty rows:  
            row.contextMenuProperty().bind(  
                    Bindings.when(row.emptyProperty())  
                    .then((ContextMenu)null)  
                    .otherwise(contextMenu)  
            );  
            return row ;  
        }  
    });