public class Controller {

    @FXML
    private TilePane buttonPane ;

    public void initialize() {
        for (int i = 1 ; i <= 55 ; i++) {
            String buttonText = "Button "+i ;
            Button button = new Button(buttonText);
            buttonPane.getChildren().add(button);
            button.setOnAction(e -> {
                // whatever you need here: you know the button pressed is the 
                // one and only button the handler is registered with
                System.out.println(buttonText + " clicked");
            });
        }
    }

    // ...
}