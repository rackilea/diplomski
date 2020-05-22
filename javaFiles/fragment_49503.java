@FXML
ProgressBar prgbProgress;

@FXML
private void onClick(ActionEvent event) {
      Task <Void> t = new Task <Void> () {

        @Override
        protected Void call() throws Exception {
          for (int i = 0; i < 10; i++) {
            updateProgress(i, 9);
            Thread.sleep(1000);
          }
          return null;
        }
      };
      prgbProgress.progressProperty().bind(t.progressProperty());
      //new Thread(t).run(); // wrong
      new Thread(t).start(); // right
}