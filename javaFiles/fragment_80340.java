// fully initialized list of factories, with employee lists initialized:
List<Factory> factories = ... ;

TreeItem<Object> root = new TreeItem<>(null);
for (Factory factory : factories) {
    TreeItem<Object> factoryItem = new TreeItem<>(factory);
    root.getChildren().add(factoryItem);
    for (Employee emp : factory.getEmployees()) {
        TreeItem<Object> employeeItem = new TreeItem<>(emp);
        factoryItem.getChildren().add(employeeItem);
    }
}
treeTable.setRoot(root);