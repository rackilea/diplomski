Name name = new Name("Rudolph", "Reindeer");
final TextField textField = new TextField("Name");
textField.setConverter(new StringToNameConverter());
textField.setConvertedValue(name);
addComponent(textField);
addComponent(new Button("Submit value", new ClickListener() {

    public void buttonClick(ClickEvent event) {
        Name name = (Name) textField.getConvertedValue();
    }

}));