ObservableMap<String, Employee> employeeMap = DataBase.getInstance().getEmployeeMap();
ListView<Employee> listView = new ListView<>();
listView.getItems().addAll(employeeMap.values());

employeeMap.addListener((Change change) -> {
    if (change.wasAdded()) {
        listView.getItems().add(change.getValueAdded());
    } else if (change.wasRemoved()) {
        listView.getItems().remove(change.getValueRemoved());
    }
});