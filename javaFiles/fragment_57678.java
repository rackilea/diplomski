row.setOnDragDropped(event -> {
   Dragboard db = event.getDragboard();
   if (acceptable(db, row)) {
       // Get all indexes.
       ArrayList<Integer> indexes = (ArrayList<Integer>) db.getContent(SERIALIZED_MIME_TYPE);

       ObservableList<TreeItem> items = FXCollections.observableArrayList();    
       // Get the item on each index.
       for (int index : indexes) {
           items.add(tree.getTreeItem(index));
       }  

       // Modify the rest of the code commented out below to remove 
       // all items in your list and then add them your target.
       // item.getParent().getChildren().remove(item);
       // getTarget(row).getChildren().add(item);
       // event.setDropCompleted(true);
       // tree.getSelectionModel().select(item);

       event.consume();
   }            
});