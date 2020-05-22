public class FileItemCheckBoxTreeCell extends TreeCell<Path> {

    private BooleanProperty oldSelectedProperty;
    private BooleanProperty oldIndeterminateProperty;

    private final CheckBox checkBox;
    private final StringConverter<TreeItem<Path>> converter;

    public FileItemCheckBoxTreeCell(StringConverter<TreeItem<Path>> converter) {
        if (converter == null) {
            throw new IllegalArgumentException();
        }
        this.converter = converter;
        this.checkBox = new CheckBox();
    }

    @Override
    protected void updateItem(Path item, boolean empty) {
        // clear old binding
        if (oldSelectedProperty != null) {
            checkBox.selectedProperty().unbindBidirectional(oldSelectedProperty);
            checkBox.indeterminateProperty().unbindBidirectional(oldIndeterminateProperty);
            oldSelectedProperty = null;
            oldIndeterminateProperty = null;
        }
        checkBox.indeterminateProperty().unbind();

        super.updateItem(item, empty);

        if (empty) {
            setGraphic(null);
            setText("");
        } else {
            TreeItem<Path> treeItem = getTreeItem();
            setText(converter.toString(treeItem));
            if (treeItem instanceof FileTreeItem) {
                setGraphic(checkBox);
                FileTreeItem fti = (FileTreeItem) treeItem;

                oldSelectedProperty = fti.selectedProperty();
                oldIndeterminateProperty = fti.indeterminateProperty();

                checkBox.selectedProperty().bindBidirectional(oldSelectedProperty);
                checkBox.indeterminateProperty().bindBidirectional(oldIndeterminateProperty);
            } else {
                setGraphic(null);
            }
        }
    }

    public static Callback<TreeView<Path>, TreeCell<Path>> forTreeView(StringConverter<TreeItem<Path>> converter) {
        if (converter == null) {
            throw new IllegalArgumentException();
        }
        return tv -> new FileItemCheckBoxTreeCell(converter);
    }

}