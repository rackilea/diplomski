@FXML
void displayFiles(ActionEvent event) throws Exception{
    Model model = new Model();

    Task<Void> task = new Task<Void>() {
        @Override
        public Void call() {
            model.status.addListener((obs, oldStatus, newStatus) -> updateMessage(newStatus));
            model.run();
            return null ;
        }
    };

    fileLabel.textProperty().bind(task.messageProperty());

    task.setOnSucceeded(e -> fileLabel.textProperty().unbind());

    new Thread(task).start();
}