final Image img = new Image(Data.class.getResourceAsStream("img.png"));

// ...

TableView<Data> table = new TableView<>();
TableColumn<Data, String> column = new TableColumn<>("Name");
column.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

column.setCellFactory(col -> new TableCell<Data, String>() {
    private final ImageView imageView = new ImageView(img);

    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            setText(item);
            setGraphic(imageView);
        }
    }
});