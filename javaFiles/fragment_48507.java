class Car {
    private final StringProperty type = new SimpleStringProperty();

    public StringProperty typeProperty() { return type; }
    public String getType() { return type.get(); }
    public void setType(String newType) { type.set(newType); }
}

class Person {
    private final ObjectProperty<Car> car = new SimpleObjectProperty<>();

    private final StringProperty name = new SimpleStringProperty();

    public ObjectProperty<Car> carProperty() { return car; }
    public Car getCar() { return car.get(); }
    public void setCar(Car newCar) { car.set(newCar); }

    public StringProperty nameProperty() { return name; }
    public String getName() { return name.get(); }
    public void setName(String newName) { name.set(newName); }
}