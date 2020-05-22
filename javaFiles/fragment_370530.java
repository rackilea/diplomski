cmdNrColumn.setCellFactory(p ->
    new TreeTableCell<Command, Command>() {
        @Override
        protected void updateItem(Command item, boolean empty) {
            // ...
            TreeTableView treeTable = p.getTreeTableView();
            // ...
        }
    });