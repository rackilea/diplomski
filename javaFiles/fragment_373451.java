private static TreeItem<MapItem> createTree(Map<String, Object> map) {
    TreeItem<MapItem> result = new TreeItem<>();

    for (Map.Entry<String, Object> entry : map.entrySet()) {
        result.getChildren().add(createTree(map, entry));
    }

    return result;
}

private static TreeItem<MapItem> createTree(Map<String, Object> map, Map.Entry<String, Object> entry) {
    MapItem mi = new MapItem(map, entry.getKey());
    TreeItem<MapItem> result = new TreeItem<>(mi);

    Object value = entry.getValue();

    if (value instanceof Map) {
        Map<String, Object> vMap = (Map<String, Object>)value;

        // recursive creation of subtrees for map entries
        for (Map.Entry<String, Object> e : vMap.entrySet()) {
            result.getChildren().add(createTree(vMap, e));
        }
    } else {
        result.getChildren().add(new TreeItem<>(new MapItem(null, value.toString())));
    }

    return result;
}

private static class MapItem {

    private final Map<String, Object> map;
    private final String value;

    public MapItem(Map<String, Object> map, String value) {
        this.map = map;
        this.value = value;
    }
}

private static class Converter extends StringConverter<MapItem> {

    private final TreeCell<MapItem> cell;

    public Converter(TreeCell<MapItem> cell) {
        this.cell = cell;
    }

    @Override
    public String toString(MapItem object) {
        return object == null ? null : object.value;
    }

    @Override
    public MapItem fromString(String string) {
        MapItem mi = cell.getItem();

        if (mi != null) {
            TreeItem<MapItem> item = cell.getTreeItem();
            if (item.isLeaf()) {
                MapItem parentItem = item.getParent().getValue();

                // modify value in parent map
                parentItem.map.put(parentItem.value, string);
                mi = new MapItem(mi.map, string);
            } else if (!mi.map.containsKey(string)) {
                // change key of mapping, if there is no mapping for the new key
                mi.map.put(string, mi.map.remove(mi.value));
                mi = new MapItem(mi.map, string);
            }
        }

        return mi;
    }

}

@Override
public void start(Stage primaryStage) {
    Map<String, Object> map = new HashMap<>();

    map.put("a", "b");

    Map<String, Object> inner = new HashMap<>();
    map.put("c", inner);
    inner.put("d", "e");

    Map<String, Object> inner2 = new HashMap<>();
    inner.put("f", inner2);
    inner2.put("g", "h");
    inner2.put("i", "j");

    TreeView<MapItem> treeView = new TreeView<>(createTree(map));
    treeView.setEditable(true);
    treeView.setShowRoot(false);

    treeView.setCellFactory(t -> {
        TextFieldTreeCell<MapItem> cell = new TextFieldTreeCell<>();
        cell.setConverter(new Converter(cell));
        return cell;
    });

    Button btn = new Button("Print Map");
    btn.setOnAction((ActionEvent event) -> {
        System.out.println(map);
    });

    VBox root = new VBox(10, btn, treeView);

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.show();
}