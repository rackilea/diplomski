public class MainPresenter {
    private final ObjectProperty<Person> person = new SimpleObjectProperty<>(this, "person") ;
    public ObjectProperty<Person> personProperty() {
        return person ;
    }
    public final Person getPerson() {
        return person.get();
    }
    public final void setPerson(Person person) {
        this.person.set(person);
    }

    public void initialize() {
        // bind to person as needed ...
        // other stuff as before
    }

    // ...
}