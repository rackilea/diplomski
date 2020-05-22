public class Damageloop {

    private ObjectProperty<Float> occurrences = new SimpleObjectProperty<>(0.0f);

    public ObjectProperty<Float> occurrencesProperty() {
        return occurrences ;
    }

    public final Float getOccurrences() {
        return occurrencesProperty().get();
    }

    public final void setOccurrences(Float occurrences) {
        occurrencesProperty().set(occurrences);
    }

    // ...
}