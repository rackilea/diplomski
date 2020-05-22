Scene scene1, scene2;

    final int WIDTH = 600;
    final int HEIGHT = 600;

    Label labelLightOrDark;

    TextField tfLightOrDark;


    private GridPane createTextFieldPane() {
        GridPane gPane = new GridPane();
        labelLightOrDark = new Label("Is it light or dark? ");

        tfLightOrDark = new TextField();

        gPane.add(labelLightOrDark, 0, 2);
        gPane.add(tfLightOrDark, 1, 2);

        return gPane;
    }

    @Override
    public void start(Stage primaryStage) {
        //first scene
        Button btGenerate = new Button("Generate My Background!");

        GridPane gPane = createTextFieldPane();
        gPane.add(btGenerate, 0, 6);
        Scene scene1 = new Scene(gPane, 600, 600);

        //second scene
        Button btReturn = new Button("Try Again!");
        btReturn.setOnAction((ActionEvent event2) -> {
            primaryStage.setScene(scene1);
        });

        Pane root = new Pane();


        root.getChildren().add(btReturn);
        Scene scene2 = new Scene(root, 600, 600);
        btGenerate.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene2);
            if (tfLightOrDark.getText().contains("light")) {
                root.setStyle("-fx-background-color: lightblue;");
            } 
            else if (tfLightOrDark.getText().contains("dark")) {
                root.setStyle("-fx-background-color: darkblue;");
            }
        });

        primaryStage.setTitle("Create Your Own Background!");
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}