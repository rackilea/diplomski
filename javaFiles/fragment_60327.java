public class Controller {

    private VBox base = new VBox();
    private ComboBox<Locale> comboBox = new ComboBox<>();
    private TextField textField = new TextField();
    private Button button = new Button("Print");

    private Hashtable<Locale, String> map = new Hashtable<>();

    public VBox getBase() {
        return base;
    }

    public Controller() {
        setupUi();

        addItem("Chinese");
        addItem("French");
        addItem("English");
        comboBox.getItems().add(new Locale("Russia", "Some Russian Text"));

        comboBox.getSelectionModel().selectedItemProperty()
                .addListener((obs, oldVal, newVal) -> textField.setText(map.get(newVal)));

        textField.textProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal == null || newVal.equals("")) {
                map.remove(comboBox.getValue());
            } else {
                map.put(comboBox.getValue(), newVal);
            }
        });

        comboBox.getSelectionModel().selectFirst();
    }

    private void setupUi() {
        base.getChildren().addAll(comboBox, textField, button);
        button.setOnAction(event -> System.out.println(map));
    }

    private void addItem(String name) {
        Locale locale = new Locale(name, String.format("Some %s text", name));
        map.put(locale, locale.text);
        comboBox.getItems().add(locale);
    }

}


class Locale {

    String name;
    String text;

    Locale(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return name;
    }

}