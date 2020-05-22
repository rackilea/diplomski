public class AClass extends SomeClass{

private final StackPane stackPane1;
private final StackPane stackPane2;

public AClass(){
    super();
    HBox hBox = new HBox();
    Button exampleButton = new Button("Example");
    exampleButton.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
            if (somenthingHapper()) {
                this.setContent(stackPane1);
            } else {
                this.setContent(stackPane2);
            }
        }
    });


    stackPane1 = new StackPane();
    stackPane1.getChildren().addAll(hBox);

    stackPane2 = new StackPane();
    stackPane2.getChildren().add(/*Some other stuff*/);

    this.setContent(stackPane1);
}
}