@FXML
private void goWindow1(ActionEvent event) {
    try {
         FXMLLoader miCargador = new
                 FXMLLoader(getClass().getResource("/vista/Window1.fxml"));

         Window1Controller window1 = new Window1Controller();
         window1.initStage(primaryStage);
         miCargador.setController(window1);

         Parent root = (Parent) miCargador.load();

                     // Access to window driver 1



      Scene scene = new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.show();
     } catch (IOException e) {e.printStackTrace();}
    }
}