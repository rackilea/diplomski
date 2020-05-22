@FXML
private void handleBtn1(ActionEvent event) throws Exception{
    Info info = new Info(textFieldA.getText(), textFieldB.getText());
    Stage stage; 
    Parent root;
    if(event.getSource()==btn1){
        //get reference to the button's stage         
        stage=(Stage) btn1.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLPassword.fxml"));
        root = loader.load();
        FXMLPasswordController passwordController = loader.getController();
        passwordController.setCurrentInfo(info);
    }
    else{
        stage=(Stage) btn1.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    }
    //create a new scene with root and set the stage
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}