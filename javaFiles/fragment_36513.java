public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Action button
        Button btnDoSomething = new Button("Do something...");
        btnDoSomething.setOnAction(e -> doTheThings(new ImplDoSomething()));

        Button btnDoSomethingElse = new Button("Do something else...");
        btnDoSomethingElse.setOnAction(e -> doTheThings(new ImplDoSomethingElse()));

        VBox mainPane = new VBox(5);
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setPadding(new Insets(10));
        mainPane.getChildren().addAll(btnDoSomething, btnDoSomethingElse);

        primaryStage.setScene(new Scene(mainPane));

        primaryStage.show();

    }

    private void doTheThings(IParameterMethod parameterMethod) {

        parameterMethod.call();

    }
}