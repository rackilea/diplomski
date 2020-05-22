public TreeView getMyFilePathTree() {

    if (filePathTree == null) {

        filePathTree = new TreeView<>(getRootItem());
        filePathTree.setPrefHeight(600.0d);
         filePathTree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // tell cell factory to use the selected property for checkbox
        filePathTree.setCellFactory(FileItemCheckBoxTreeCell.forTreeView(new StringConverter<TreeItem<Path>>() {

            @Override
            public String toString(TreeItem<Path> object) {
                if (object == null) {
                    return "";
                }
                Path p = object.getValue();
                if (p == null) {
                    return "";
                }
                p = p.getFileName();
                return p == null ? object.getValue().toString() : p.toString();
            }

            @Override
            public TreeItem<Path> fromString(String string) {
                throw new UnsupportedOperationException();
            }

        }));
        filePathTree.setShowRoot(false);
    }

    return filePathTree;
}