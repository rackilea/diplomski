public class OptionsController {

    @FXML
    private RadioButton radioButton1 ;

    @FXML
    private RadioButton radioButton2 ;

    private SomeType someValue1 = new SomeType();
    private SomeType someValue2 = new SomeType();

    private final ReadOnlyObjectWrapper<SomeType> selectedThing = new ReadOnlyObjectWrapper<>();

    public ReadOnlyObjectProperty<SomeType> selectedThingProperty() {
        return selectedThing.getReadOnlyProperty() ;
    }

    public final SomeType getSelectedThing() {
        return selectedThingProperty().get();
    }

    public void initialize() {
        radioButton1.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (isNowSelected) {
                selectedThing.set(someValue1);
            }
        });
        radioButton2.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (isNowSelected) {
                selectedThing.set(someValue2);
            }
        });
    }

    // ...
}