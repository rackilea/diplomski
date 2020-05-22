TableColumn<tableDataModel, ImageView> col = new TableColumn<>();
    tableView.getColumns().add(col);
    imageList.add(new tableDataModel(new ImageView(convertToFxImage(clip.getThumbnail()))));
col.setPrefWidth(50);
    col.setCellValueFactory(new PropertyValueFactory<tableDataModel, ImageView>("image"));

    int i = 0;
    while (i != 10) {



    try {
            imageList.add(new tableDataModel(new ImageView(convertToFxImage(clip.getNextFrame()))));
        } catch (Exception e) {
        }
        i++;
}
tableView.setItems(imageList);