Hyperlink link = new Hyperlink();
link.setText("http://example.com");
link.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        FXMLLoader load = new 
        FXMLLoader(getClass().getResource("InEX.fxml"));
        Parent root = (Parent) load.load();
        Stage stage = new Stage();

        stage.setScene(new Scene(root));
        stage.show();

        link = (Hyperlink) event.getTarget();
        model = link.getId();

        stage.setTitle(model);
    }
});