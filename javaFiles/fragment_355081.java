tablesListView.setEditable(true);
tablesListView.setCellFactory(TextFieldListCell.forListView());
tablesListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

final Timeline animation = new Timeline(
        new KeyFrame(Duration.seconds(.1),
        new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                tablesListView.edit(tablesListView.getSelectionModel().getSelectedIndex());
            }
        }));
animation.setCycleCount(1);

addTableButton.setOnAction(new EventHandler<ActionEvent>(){
    @Override
    public void handle(ActionEvent evt) {
        tablesListView.getItems().add("");
        tablesListView.getSelectionModel().selectLast();
        animation.play();
    }
});