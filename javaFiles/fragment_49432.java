@FXML
private void test(){
    textField.setText("Pending...");
    Thread t = new Thread(){
        @Override public void run(){
            boolean passed = doStuff();
            Platform.runLater(() -> {
                if(passed){
                    textField.setText("OK");
                } else {
                    textField.setText("Error");
                }
            });
        }
    };
    t.start();
}