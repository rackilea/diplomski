TreeItem<String> root = new TreeItem<String>("Tree Root");
root.getChildren().addAll(
    new EditableTreeItem<String>("Item 1"),
    new EditableTreeItem<String>("Item 2"),
    new EditableTreeItem<String>("Item 3")
);