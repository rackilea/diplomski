final int defaultValue = 0;

Map<StringItem, ObjectProperty<Integer>> map = new HashMap<>();

// fill map with existing keys
budgetData.forEach(i -> map.put(i, new SimpleObjectProperty(defaultValue)));

// update map on change of list
budgetData.addListener((ListChangeListener.Change<? extends StringItem> c) -> {
    while (c.next()) {
        c.getRemoved().forEach(map::remove);
        c.getAddedSubList().forEach(i -> map.put(i, new SimpleObjectProperty(defaultValue)));
    }
});

// use value in map as value for column
quantityColumn.setCellValueFactory(d -> map.get(d.getValue()));
quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));