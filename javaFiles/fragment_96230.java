public class StageTest extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Update Category");
        ObservableList<String> items
                    = FXCollections.observableArrayList(createStrings());
        ListView<String>  skillListView = new ListView<>(items);

        TextField categoryField = new TextField();
        categoryField.setText("Category");

        VBox righta = new VBox();
        righta.getChildren().addAll(categoryField,skillListView);
        righta.setAlignment(Pos.BASELINE_LEFT);

        BorderPane layout = new BorderPane();
        layout.setRight(righta);

        Scene scene2 = new Scene(layout, 300, 300);
        stage.setScene(scene2);
        stage.show();
    }

    private List<String> createStrings() {
        return IntStream.rangeClosed(0, 5)
                .mapToObj(i -> "Skill "+i)
                .map(String::new)
                .collect(Collectors.toList());
    }
}