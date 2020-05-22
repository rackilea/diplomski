ComboBox<String> combo = new ComboBox<String>(list);
Button change = new Button("change");
change.setOnAction((event) -> {
    StringBuilder str = combo.getValue();
    list.set(5, new String("-"));
    combo.setValue(str);
});