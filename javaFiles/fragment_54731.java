public class ChangeSize {

public ChangeSize(FXMLDocumentController controller) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Pane pane = controller.getPane();
                pane.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));

            }
        });



    }