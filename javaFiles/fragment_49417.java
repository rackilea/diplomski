public static class Test{

private StringProperty name;

private Test() {
   name = new SimpleStringProperty();
}

public Test(String name) {
    this.name = new SimpleStringProperty(name);
}

public void setName(String name) {
    this.name.set(name);
}

public String getName() {
    return name.get();
}

public StringProperty nameProperty() {
    return name;
}