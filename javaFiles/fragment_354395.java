public class LoweredEtchedBorderLabelDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        LEBLabel text = new LEBLabel("Testing", 200, 30);

        StackPane root = new StackPane();
        root.getChildren().add(text);
        root.setStyle("-fx-background-color:lightgrey");

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Lowered-Etched-Border Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Lowered Etched Borderd Label
    private class LEBLabel extends Label {
        private HBox[] borders = new HBox[3];
        private String border_styles[] = {"-fx-border-width:0 1 1 0; -fx-border-color: white",
                                          "-fx-border-width:1; -fx-border-color:grey",
                                          "-fx-border-width:1 0 0 1; -fx-border-color:white"};

        public LEBLabel(String text, double width, double height) {
            super(text);
            for(int i = 0; i < borders.length; i++) {
                borders[i] = new HBox();
                borders[i].setStyle(border_styles[i]);

                //decrement of border-size for inner-border, prevents from the overlapping of border
                borders[i].setMaxSize(width - (1.5 *i), height - (1.5 * i));
                borders[i].setMinSize(width - (1.5 *i), height - (1.5 * i));

                borders[i].setSpacing(0);
            }
            this.setContentDisplay(ContentDisplay.CENTER);
            this.borders[1].getChildren().add(borders[2]);
            this.borders[0].getChildren().add(borders[1]);
            this.setGraphic(borders[0]);
        }       
    }

    public static void main(String[] args) {
        launch(args);
    }

}