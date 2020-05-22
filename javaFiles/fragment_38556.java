if (pressed_button == btnscadalogin) {
    if (loginLoad.validateSCADA(username, password)) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Screen3_Scada.fxml"));

        try {
            AnchorPane pane = loader.load();
            RootPane.getChildren().setAll(pane);

            Screen3_Scada_Controller getbtnPLC = loader.getController();
            getbtnPLC.getBtngotoPLC().setDisable(true);

        } catch (IOException ex) {
            System.err.println("Error in method GotoScreen2 class FXML_Screen1_loginController");
        }
   }