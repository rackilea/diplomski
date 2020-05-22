public static class User {

    private final StringProperty name;
    private final ObjectProperty<LocalDate> birthday;

    private ReadOnlyIntegerWrapper age = null;

    public StringProperty nameProperty() { return name; }
    public ObjectProperty<LocalDate> birthdayProperty() { return birthday; }

    public ReadOnlyIntegerProperty ageProperty() {
        if (age == null) {
            age = new ReadOnlyIntegerWrapper();
            age.bind(Bindings.createIntegerBinding(() -> calculateAge(), birthday));
        }

        return age.getReadOnlyProperty();
    }

    private User(String name, LocalDate bDay) {
        this.name = new SimpleStringProperty(name);
        birthday = new SimpleObjectProperty<LocalDate>(bDay);
    }

    public String getName() { return name.get(); }

    public LocalDate getBirthday() {return birthday.get(); }

    public int getAge() {
        return (age != null) ? age.get() : calculateAge();
    }

    private final int calculateAge() {
        return Period.between(this.getBirthday(), LocalDate.now()).getYears();
    }
}