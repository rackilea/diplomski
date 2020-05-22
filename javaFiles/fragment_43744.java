// @formatter:off
private StringProperty name = new SimpleStringProperty();
public StringProperty nameProperty() { return name; }
public String getName() { return name.get(); }
public void setName(String value) { this.name.set(value); }
// @formatter:on