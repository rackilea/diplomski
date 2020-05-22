TableColumn<User, Integer> ageCol = new TableColumn<User, Integer>("Age");

ageCol.setCellValueFactory(param -> {
    SimpleIntegerProperty prop = new SimpleIntegerProperty(param.getValue().getAge());
    prop.bind(Bindings.createIntegerBinding(() -> {
        return param.getValue().getAge();
    }, param.getValue().birthday));
    return prop.asObject();
});