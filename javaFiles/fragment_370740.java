public class Main extends Application {

    private Label capsLabel = new Label("Caps is ON");

    private boolean capsIsOn;

    @Override
    public void start(Stage stage) {
        System.out.println(Toolkit.getDefaultToolkit().getLockingKeyState(20));

        //Try adding this line to get state on startup
        capsLabel.setVisible(Toolkit.getDefaultToolkit().getLockingKeyState(20));

        TextField textField = new TextField();

        //Also try adding this line and to check again so when the field 
        //is selected it will check again
        textField.setOnMouseClicked(event -> capsLabel.setVisible(Toolkit.getDefaultToolkit().getLockingKeyState(20)));

        textField.setOnKeyReleased(keyEvent -> {
            if(keyEvent.getCode().toString().equals("CAPS")){
                capsIsOn = !capsIsOn;
                capsLabel.setVisible(capsIsOn);
            }
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(textField, capsLabel);

        stage = new Stage();
        stage.setScene(new Scene(vBox));
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}