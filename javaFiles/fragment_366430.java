public class View extends VBox {

    private final Controller controller ;

    public View(Controller controller) {
        this.controller = controller ;
        buildUI();
    }

    private void buildUI() {
        setPadding(new Insets(10,10,10,10));

        Button addItem = new Button("Add Item");
        addItem.setPrefWidth(120);
        Button cancelation = new Button("Close");
        cancelation.setPrefWidth(120);
        cancelation.setOnAction(e -> controller.exit(this));

        getChildren().addAll(addItem, /* sellItem, */ cancelation);
        setAlignment(Pos.CENTER);
   }
}