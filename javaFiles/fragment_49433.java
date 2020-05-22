@FXML
private void test(){
    textField.setText("Pending...");
    Task<Boolean> task = new Task<>() {
        @Override protected Boolean call() throws Exception {
            return doStuff();
        }
    };
    task.setOnSucceeded(event -> textField.setText(task.getValue() ? "Ok" : "Error"));
    new Thread(task).start();
}