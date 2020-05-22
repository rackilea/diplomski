@FXML
void displayFiles(ActionEvent event) throws Exception{
    Model model = new Model();

    ChangeListener<String> listener = (obs, oldStatus, newStatus) -> fileLabel.setText(newStatus);
    model.status.addListener(listener);

    Thread thread = new Thread(model);

    thread.start();
}