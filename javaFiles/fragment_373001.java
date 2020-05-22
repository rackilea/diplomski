TreeView<String> treeView = new TreeView<>();
treeView.setCellFactory(tv -> {
    TreeCell<String> cell = new TreeCell<>(); // or some custom implementation
    cell.setOnMouseClicked(event -> {
        TreeItem<String> item = cell.getTreeItem();
        // do something with item...
    });
    return cell;
});