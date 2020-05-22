public class UpdateableComboBox extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ObservableList<Hero> heros 
        = FXCollections.observableArrayList((Hero param) -> new Observable[] { param.nameProperty(), param.levelProperty() });
        heros.add(new Hero("Ted", 1));
        heros.add(new Hero("Zed", 10));
        heros.add(new Hero("Med", 25));

        ComboBox<Hero> comboBox = new ComboBox<>();
        comboBox.setPrefWidth(350);
        comboBox.setItems(heros);
        Button button = new Button("Level Up");
        button.setOnAction(e -> {
             Hero value = comboBox.getValue();
             value.levelProperty().setValue(value.getLevel() + 1);
        });

        comboBox.setConverter(new StringConverter<Hero>() {
            @Override
            public String toString(Hero hero) {
                return hero.getName() + " - Level: " +  hero.getLevel();
            }

            @Override
            public Hero fromString(String string) {
                return null;
            }
        });

        HBox hbox = new HBox(comboBox, button);
        Scene scene = new Scene(hbox, 500, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }

    private  class Hero {
        private StringProperty name = new SimpleStringProperty();
        private IntegerProperty level = new SimpleIntegerProperty();
        Hero(String name, int level){
            this.name.set(name);
            this.level.set(level);
        }
        public final StringProperty nameProperty() {
            return this.name;
        }

        public final String getName() {
            return this.nameProperty().get();
        }

        public final void setName(final String name) {
            this.nameProperty().set(name);
        }

        public final IntegerProperty levelProperty() {
            return this.level;
        }

        public final int getLevel() {
            return this.levelProperty().get();
        }

        public final void setLevel(final int level) {
            this.levelProperty().set(level);
        }

    }

}