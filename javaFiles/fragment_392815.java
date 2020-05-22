public class Task {

    private ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();

    // ...

    public ObjectProperty<LocalDate> dateProperty() {
        return date ;
    }

    public final LocalDate getDate() {
        return dateProperty().get();
    }

    public final void setDate(LocalDate date) {
        dateProperty().set(date);
    }
}