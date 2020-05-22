Task<Parent> task = new Task<Parent>() {
    @Override
    protected Parent call() throws Exception {
        return FXMLLoader.load(getClass().getResource("sample2.fxml"));
    }
};

task.setOnSucceeded(event -> {
    Parent root = task.getValue();
    Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.show();
};