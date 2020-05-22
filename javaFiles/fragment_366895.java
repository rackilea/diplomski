KiwiId.setCellFactory(new Callback<TableColumn<NewBeautifulKiwi, Integer>, TableCell<NewBeautifulKiwi, Integer>>() {
    @Override
    public TableCell<NewBeautifulKiwi, Integer> call(TableColumn<NewBeautifulKiwi, Integer> param) {
      ...
      TableCell<NewBeautifulKiwi, Integer> cell = new TableCell<NewBeautifulKiwi, Integer>() {
         public void updateItem(Integer item, boolean empty) {
            if (item != null) {
              imageview.setImage(new Image("arrow.png"));
            }
         }
      };
      // Attach the imageview to the cell
      cell.setGraphic(imageview);
      return cell;
    }
 });
 KiwiId.setCellValueFactory(new PropertyValueFactory<NewBeautifulKiwi, Integer>("KiwiId"));