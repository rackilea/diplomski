myColumn.setCellFactory(factory -> new TreeTableCell<MyModel, String>(){
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if(empty){
                setText(null);
                setGraphic(null);
                return;
            }
            // if empty is false, then these references should not be null
            MyModel myModel = getTreeTableRow().getItem();
            TreeItem<MyModel> treeItem = getTreeTableRow().getTreeItem();
        }
    });