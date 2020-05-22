public class ChangeSize {

    public ChangeSize() {

        Parent loaded=null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        try {
            loaded = (Parent) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(loaded);

        JavaFXMLApplication3.staticstage.setScene(scene);
        JavaFXMLApplication3.staticstage.show();  
        FXMLDocumentController controller = (FXMLDocumentController) loader.getController();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Pane pane = controller.getPane();
                    pane.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));

                }
            });



        }


    }