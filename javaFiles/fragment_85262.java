public class TreeController implements Initializable {

    ...

    @FXML
    private TreeView<Object> treeView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeItem<Object> root = new TreeItem<>("Groups");

        for (Object object : cfg.getGroupList()) {
            root.getChildren().add(createNode(object));
        }

        treeView.setRoot(root);
        treeView.setCellFactory(p -> new TreeCellFactory());

        root.setExpanded(true);
    }

    private TreeItem<Object> createNode(Object o) {
        return new TreeItem<Object>(o) {
            private boolean isLeaf;
            private boolean isFirstTimeChildren = true;
            private boolean isFirstTimeLeaf = true;

            @Override
            public ObservableList<TreeItem<Object>> getChildren() {
                if (isFirstTimeChildren) {
                    isFirstTimeChildren = false;

                    super.getChildren().setAll(buildChildren(this));
                }
                return super.getChildren();
            }

            @Override
            public boolean isLeaf() {
                if (isFirstTimeLeaf) {
                    isFirstTimeLeaf = false;

                    if (o instanceof Topic) {
                        isLeaf = true;
                    }
                }

                return isLeaf;
            }

            private ObservableList<TreeItem<Object>> buildChildren(TreeItem<Object> treeItem) {
                if (treeItem.getValue() instanceof Group) {
                    ObservableList<TreeItem<Object>> children = FXCollections.observableArrayList();

                    for (Object object : ((Group) treeItem.getValue()).getTopicList()) {
                        children.add(createNode(object));
                    }

                    return children;
                }

                return FXCollections.emptyObservableList();
            }
        };
    }

    private final class TreeCellFactory extends TreeCell<Object> {
        private ContextMenu topicMenu = new ContextMenu();
        private ContextMenu groupMenu = new ContextMenu();

        public TreeCellFactory() {
            MenuItem topicMenuItem = new MenuItem("- Item 1 -");
            topicMenu.getItems().add(topicMenuItem);

            MenuItem groupMenuItem = new MenuItem("- Item 1 -");
            groupMenu.getItems().add(groupMenuItem);
        }

        @Override
        public void updateItem(Object item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
            } else {
                setText(item.toString());
            }

            if (item instanceof Topic) {
                setContextMenu(topicMenu);
            }

            if (item instanceof Group) {
                setContextMenu(groupMenu);
            }
        }


    }
}