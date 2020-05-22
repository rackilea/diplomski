try {
  //Load the view and controller
  FXMLLoader loader = new FXMLLoader(getClass().getResource("displayPassword.fxml"));
  Parent displayPassword = (Parent)loader.load();
  Scene displayPasswordScene = new Scene(displayPassword);
  displayPasswordController controller = loader.getController();
  //Generate the password and set it
  controller.setPwdValue(Pastis.model.getNewPassword());
  //Load the new view on the stage
  Main.getStage().setScene(displayPasswordScene);
  Main.getStage().show();      
} catch (IOException e) {
  // TODO Auto-generated catch block
  e.printStackTrace();
}