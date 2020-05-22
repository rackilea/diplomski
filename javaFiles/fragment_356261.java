public static class User {

    private final StringProperty name;
    private final ObjectProperty<LocalDate> birthday;

    private final ReadOnlyIntegerWrapper age;

    public StringProperty nameProperty() { return name; }
    public ObjectProperty<LocalDate> birthdayProperty() { return birthday; }
    public ReadOnlyIntegerProperty ageProperty() { return age.getReadOnlyProperty(); }

    private User(String name, LocalDate bDay) {
        this.name = new SimpleStringProperty(name);
        birthday = new SimpleObjectProperty<LocalDate>(bDay);
        this.age = new ReadOnlyIntegerWrapper();
        age.bind(Bindings.createIntegerBinding(() -> Period.between(this.getBirthday(), LocalDate.now()).getYears(), birthday));
    }

    public String getName() { return name.get(); }
    public LocalDate getBirthday() { return birthday.get(); }
    public int getAge() { return ageProperty().get(); }
}