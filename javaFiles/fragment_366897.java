...
@FXML
private TableColumn<NewBeautifulKiwi, Image> KiwiImageCol;
...
@Override
public void initialize(URL url, ResourceBundle rb) {
    KiwiImageCol.setCellFactory(param -> {
       //Set up the ImageView
       final ImageView imageview = new ImageView();
       imageview.setFitHeight(50);
       imageview.setFitWidth(50);

       //Set up the Table
       TableCell<NewBeautifulKiwi, Image> cell = new TableCell<NewBeautifulKiwi, Image>() {
           public void updateItem(Image item, boolean empty) {
             if (item != null) {
                  imageview.setImage(item);
             }
           }
        };
        // Attach the imageview to the cell
        cell.setGraphic(imageview);
        return cell;
   });
   KiwiImageCol.setCellValueFactory(new PropertyValueFactory<NewBeautifulKiwi, Image>("kiwiImage"));
}