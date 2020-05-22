@FXML private TableColumn<PlayerManager, PlayerManager> tableColumnType;
@FXML private void initialize(){

    tableColumnType.setCellValueFactory(cellData -> new SimpleObjectProperty<PlayerManager>(cellData.getValue());

    tableColumnType.setCellFactory(param -> {
        //Set up the ImageView
        final ImageView imageview = new ImageView();
        imageview.setFitHeight(10);
        imageview.setFitWidth(10);
        ///imageview.setImage(imageComputer); //uncommenting this places the image on all cells, even empty ones
        //Set up the Table
        TableCell<PlayerManager, PlayerManager> cell = new TableCell<PlayerManager, PlayerManager>() {
            @Override
            public void updateItem(PlayerManager item, boolean empty) {
                if (item != null) {  // choice of image is based on values from item, but it doesn't matter now
                    imageview.setImage(imageComputer);
                } else {
                    imageView.setImage(null);
                }
            }
        };

        // Attach the imageview to the cell
        cell.setGraphic(imageview);
        return cell;
    });
}