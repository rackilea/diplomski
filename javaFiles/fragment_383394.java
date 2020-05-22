private final StringProperty description = new SimpleStringProperty();
public String getDescription() {
  return description.get();
}
public void setDescription(String description) {
  this.description.set(description);
}
public StringProperty descriptionProperty(){
  return description;
}