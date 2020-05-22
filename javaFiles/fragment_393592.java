public class ComboTest extends Application {

        @Override
        public void start(Stage primaryStage) throws IOException {

            primaryStage.setTitle("Populate combo from custom builder");

            Group group = new Group();
            GridPane grid = new GridPane();
            grid.setPadding(new Insets(25, 25, 25, 25));
            group.getChildren().add(grid);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("combo.fxml"));
            loader.getNamespace().put("itemLoader", new ComboLoader());
            ComboBox<String>combo = loader.load();
            grid.add(combo, 0, 0);

            Scene scene = new Scene(group, 450, 175);

            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }