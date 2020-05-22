public class MainWindowController {

    @FXML
    // Note: it is ALWAYS a mistake to initialize @FXML-injected fields.
    // Just declare them and let the FXMLLoader initialize them
    // (that is the whole point of @FXML)
    private TextField konsumatoriPunetField ;

    private ZgjedhKonsumatorinController zgjedhKonsumatorinController ;

    @FXML
    private void initialize()
    {
        FXMLLoader loader5 = new FXMLLoader();
        loader5.setLocation(getClass().getResource("ZgjedhKonsumatorinFXML.fxml"));
        BorderPane border5 = new BorderPane();
        border5 = loader5.load();
        zgjedhKonsumatorinController = loader.getController();
        Scene scene5 = new Scene(border5);
        zgjedhkonsumatorinstage.setScene(scene5);
        zgjedhkonsumatorinstage.setTitle("Pit Stop");
        zgjedhkonsumatorinstage.initModality(Modality.WINDOW_MODAL);
        zgjedhkonsumatorinstage.initOwner(MainFXMLController.mainFXMLStage);
    }

    @FXML
    public void zgjedhKonsumatorin()
    {
        zgjedhkonsumatorinstage.showAndWait();
        konsumatoriPunetField.setText(zgjedhKonsumatorinController.getText());
    }

}