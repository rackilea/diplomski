public class Person {
    private String firstName;
    private String lastName;

    public final String getFirstName() { return firstName; }
    public final void setFirstName(String firstName) { this.firstName = firstName; }

    public final String getLastName() { return lastName; }
    public final void setLastName(String lastName) { this.lastName = lastName; }
}

TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
firstNameCol.setCellValueFactory(new Callback<CellDataFeatures<Person, String>, ObservableValue<String>>() {
    public ObservableValue<String> call(CellDataFeatures<Person, String> p) {
        return new SimpleStringProperty(getPropertyReflectively(p.getValue(), "firstName", String.class));
    }
});

private static <T> T getPropertyReflectively(Object bean, String propertyName, Class<T> propertyType) {
    // Implementation to get property value reflectively
}