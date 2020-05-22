private static void put(Map<TablePos, Event> map, Event evt) {
    map.put(new TablePos(evt.getX(), evt.getY()), evt);
}

@Override
public void start(Stage primaryStage) {
    ObservableMap<TablePos, Event> contents = FXCollections.observableHashMap();

    TableView<Integer> tableView = new TableView<>(FXCollections.observableArrayList());

    TableColumn columnGroup = new TableColumn("Heutige Termine");

    ChangeListener<Number> xChangeListener = (observable, oldValue, newValue) -> {
        Event evt = (Event) ((Property) observable).getBean();
        TablePos oldPos = new TablePos(oldValue.intValue(), evt.getY());
        TablePos newPos = new TablePos(newValue.intValue(), evt.getY());
        contents.remove(oldPos);
        contents.put(newPos, evt);
    };

    ChangeListener<Number> yChangeListener = (observable, oldValue, newValue) -> {
        Event evt = (Event) ((Property) observable).getBean();
        TablePos oldPos = new TablePos(evt.getX(), oldValue.intValue());
        TablePos newPos = new TablePos(evt.getX(), newValue.intValue());
        contents.remove(oldPos);
        contents.put(newPos, evt);
    };

    contents.addListener((MapChangeListener.Change<? extends TablePos, ? extends Event> change) -> {
        if (change.wasRemoved()) {
            Event evt = change.getValueRemoved();
            evt.xProperty().removeListener(xChangeListener);
            evt.yProperty().removeListener(yChangeListener);
        }
        if (change.wasAdded()) {
            Event evt = change.getValueAdded();
            evt.xProperty().addListener(xChangeListener);
            evt.yProperty().addListener(yChangeListener);
        }

    });

    // items denote the y coordinate
    for (int i = 0; i < 10; i++) {
        tableView.getItems().add(i);
    }

    // one column per x coordiante
    for (int i = 0; i < 10; i++) {
        final int index = i;
        TableColumn<Integer, String> column = new TableColumn<>();

        // take value from Map using x (index) and y (item value)
        column.setCellValueFactory(cd
                -> Bindings.selectString(
                        Bindings.valueAt(contents, new TablePos(index, cd.getValue())), "name"));

        columnGroup.getColumns().add(column);
    }

    tableView.getColumns().add(columnGroup);

    Event opTarget = new Event("Something", 2, 9);

    put(contents, new Event("SP1", 0, 0));
    put(contents, new Event("SP2", 1, 0));
    put(contents, opTarget);

    Button move = new Button("move");
    move.setOnAction(evt -> opTarget.setX(9 - opTarget.getX()));
    Button rename = new Button("rename");
    rename.setOnAction(evt -> opTarget.setName(opTarget.getName().equals("42") ? "Answer" : "42"));

    Scene scene = new Scene(new VBox(10, tableView, move, rename));

    primaryStage.setScene(scene);

    primaryStage.show();
}