@FXML private TableColumn<PlayerManager, Image> tableColumnType;
@FXML private void initialize(){

tableColumnType.setCellFactory(param -> {
        //Set up the ImageView
        final ImageView imageview = new ImageView();
        imageview.setFitHeight(10);
        imageview.setFitWidth(10);
        ///imageview.setImage(imageComputer); //uncommenting this places the image on all cells, even empty ones
        //Set up the Table
        TableCell<PlayerManager, Image> cell = new TableCell<PlayerManager, Image>() {
            @Override
            public void updateItem(Image item, boolean empty) {
                if (item != null) {  // choice of image is based on values from item, but it doesn't matter now
                    imageview.setImage(imageComputer);
                }
            }
        };

        // Attach the imageview to the cell
        cell.setGraphic(imageview);
        return cell;
    });
}