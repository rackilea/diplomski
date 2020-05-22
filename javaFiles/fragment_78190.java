cell.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
    if (getTreeItem() != null) {
         Object target = e.getTarget();
         if (target instanceof Node && ((Node)target).getStyleClass().contains("arrow")) {
             getTreeItem().setExpanded(! getTreeItem().isExpanded());
         }
     }
     e.consume();
});