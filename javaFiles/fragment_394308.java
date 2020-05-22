public AnimatedRow(Function<T, StringExpression> nameExtractor, ObservableList<Person> observableListOfPerson, FilteredList<Person> filterListOfPerson, TabPane fxTabPaneLower) {
    setOnMouseClicked(event -> {
        if (event.getClickCount() == 2 && (!isEmpty()) ) {
            final StringExpression nameBE = nameExtractor.apply(getItem());
            filterListOfPerson.setPredicate(p-> p.getName().equals(nameBE.get()));

            fxTabPaneLower.getSelectionModel().select(1);
            ((TableView<Person>)fxTabPaneLower.getTabs().get(1).getContent()).setItems(filterListOfPerson);              
        }
    });
}