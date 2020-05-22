public class FileTreeItem extends TreeItem<Path> {

    private boolean isLeaf;
    private boolean isFirstTimeChildren = true;
    private boolean isFirstTimeLeaf = true;

    private final BooleanProperty selected;
    private final BooleanProperty indeterminate;

    protected FileTreeItem(Path path, boolean selected) {
        super(path);
        this.indeterminate = new SimpleBooleanProperty();
        this.selected = new SimpleBooleanProperty(selected);
        this.selected.addListener((o, oldValue, newValue) -> {
            if (!updating) {
                if (!isLeaf() && !isFirstTimeChildren) {
                    // propagate selection to children if they were created yet
                    for (TreeItem<Path> ti : getChildren()) {
                        FileTreeItem fti = (FileTreeItem) ti;
                        fti.setSelected(newValue);
                    }
                }

                // update ancestors
                TreeItem<Path> parent = getParent();
                while ((parent instanceof FileTreeItem)
                        && updateAncestorState((FileTreeItem) parent)) {
                    parent = parent.getParent();
                }
            }
        });
    }

    /**
     * flag preventing circular calls during update.
     */
    private boolean updating;

    protected static boolean updateAncestorState(FileTreeItem item) {
        List<TreeItem<Path>> children = item.getChildren();

        boolean hasUnselected = false;
        boolean hasSelected = false;
        for (Iterator<TreeItem<Path>> it = children.iterator();!(hasSelected && hasUnselected) && it.hasNext();) {
            TreeItem<Path> ti = it.next();
            FileTreeItem child = (FileTreeItem) ti;
            if (child.isSelected()) {
                hasSelected = true;
            } else {
                hasUnselected = true;
                if (child.isIndeterminate()) {
                    hasSelected = true;
                }
            }
        }

        item.updating = true;
        boolean changed = false;

        if (hasUnselected) {
            if (item.isSelected() || item.isIndeterminate() != hasSelected) {
                changed = true;
                item.setSelected(false);
                item.setIndeterminate(hasSelected);
            }
        } else {
            if (!item.isSelected()) {
                changed = true;
                item.setSelected(true);
            }
            item.setIndeterminate(false);
        }
        item.updating = false;

        return changed;
    }

    public FileTreeItem(Path path) {
        this(path, false);
    }

    @Override
    public boolean isLeaf() {
        if (isFirstTimeLeaf) {
            isFirstTimeLeaf = false;
            Path path = getValue();
            isLeaf = Files.isRegularFile(path);
        }
        return isLeaf;
    }

    @Override
    public ObservableList<TreeItem<Path>> getChildren() {

        if (isFirstTimeChildren) {
            isFirstTimeChildren = false;
            super.getChildren().setAll(buildChildren(this));
        }

        return super.getChildren();
    }

    private List<TreeItem<Path>> buildChildren(FileTreeItem treeItem) {
        Path path = treeItem.getValue();
        if ((path != null) && (Files.isDirectory(path))) {
            final boolean select = treeItem.isSelected();
            try (Stream<Path> pathStream = Files.list(path)) {
                List<TreeItem<Path>> res = new ArrayList<>();
                pathStream
                        .map(p -> new FileTreeItem(p, select))
                        .forEach(res::add);
                return res;
            } catch (IOException e) {
            }
        }

        return Collections.emptyList();
    }

    /* methods for selected & indeterminate properties */
}