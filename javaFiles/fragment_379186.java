ObservableList<NumericCombo> immutable = 
        FXCollections.unmodifiableObservableList(values);
 //       new ImmutableObservableList<>(values);

TableView<NumericCombo> tableView = new TableView<>();
SortedList sorted = new SortedList(immutable);
tableView.setItems(sorted);
sorted.comparatorProperty().bind(tableView.comparatorProperty());